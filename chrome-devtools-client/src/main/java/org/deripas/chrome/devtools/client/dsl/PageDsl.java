package org.deripas.chrome.devtools.client.dsl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.CDPException;
import org.deripas.chrome.devtools.client.Disposable;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.protocol.api.network.Network;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.network.Response;
import org.deripas.chrome.protocol.api.network.event.LoadingFailedEvent;
import org.deripas.chrome.protocol.api.network.event.LoadingFinishedEvent;
import org.deripas.chrome.protocol.api.network.event.RequestWillBeSentEvent;
import org.deripas.chrome.protocol.api.network.event.ResponseReceivedEvent;
import org.deripas.chrome.protocol.api.page.FrameId;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.target.TargetID;

import java.io.Closeable;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Slf4j
public class PageDsl implements Closeable {

    @Getter
    private final TargetID id;
    private final CDPSession session;

    private final Map<RequestId, RequestState> requestState;
    private final Map<FrameId, RequestId> documentRequestByFrame;
    private final Disposable disposable;

    public PageDsl(TargetID targetId, CDPSession session, Consumer<PageDsl> closeCallback) {
        this.session = session;
        this.id = targetId;

        requestState = new ConcurrentHashMap<>();
        documentRequestByFrame = new ConcurrentHashMap<>();

        final List<Disposable> disposables = List.of(
            session.subscribe(RequestWillBeSentEvent.ID, this::onEvent),
            session.subscribe(ResponseReceivedEvent.ID, this::onEvent),
            session.subscribe(LoadingFinishedEvent.ID, this::onEvent),
            session.subscribe(LoadingFailedEvent.ID, this::onEvent)
        );
        disposable = () -> {
            disposables.forEach(Disposable::dispose);
            requestState.clear();
            documentRequestByFrame.clear();
            closeCallback.accept(this);
        };
    }

    @SneakyThrows
    public PageResponse navigate(String url) {
        return session.getPage()
            .stopLoading()
            .thenCompose(ignore -> session.getPage()
                .navigate(Page.NavigateRequest.builder()
                    .url(url)
                    .build())
                .thenCompose(this::toPageResponse))
            .join();
    }

    public byte[] screenshot(Page.CaptureScreenshotRequest.Format format) {
        return session.getPage()
            .captureScreenshot(Page.CaptureScreenshotRequest.builder()
                .format(format)
                .build())
            .thenApply(Page.CaptureScreenshotResponse::getData)
            .thenApply(data -> Base64.getDecoder().decode(data))
            .join();
    }

    @Override
    public void close() {
        disposable.dispose();
    }

    private CompletionStage<PageResponse> toPageResponse(Page.NavigateResponse navigateResponse) {
        final RequestId requestId = documentRequestByFrame.remove(navigateResponse.getFrameId());
        if (navigateResponse.getErrorText() != null) {
            requestState.remove(requestId);
            return CompletableFuture.failedFuture(new CDPException(navigateResponse.getErrorText()));
        }
        final RequestState state = requestState.get(requestId);
        return state.getLoaded()
            .thenCompose(response -> getResponseBody(requestId)
                .thenApply(body -> PageResponse.builder()
                    .status(response.getStatus())
                    .body(body)
                    .build()))
            .whenComplete((pageResponse, throwable) -> {
                requestState.remove(requestId);
            });
    }

    private CompletableFuture<String> getResponseBody(RequestId requestId) {
        return session.getNetwork()
            .getResponseBody(Network.GetResponseBodyRequest.builder()
                .requestId(requestId)
                .build())
            .thenApply(getResponseBodyResponse -> {
                if (Boolean.TRUE.equals(getResponseBodyResponse.getBase64Encoded())) {
                    final byte[] bytes = Base64.getDecoder().decode(getResponseBodyResponse.getBody());
                    return new String(bytes);
                } else {
                    return getResponseBodyResponse.getBody();
                }
            });
    }

    private void onEvent(RequestWillBeSentEvent event) {
        if (event.getType() == ResourceType.DOCUMENT
            && event.getRequest().getUrl().equals(event.getDocumentURL())) {
            requestState.computeIfAbsent(event.getRequestId(), RequestState::new);
            documentRequestByFrame.put(event.getFrameId(), event.getRequestId());
        }
    }

    private void onEvent(ResponseReceivedEvent event) {
        requestState.computeIfPresent(event.getRequestId(), (requestId, state) -> {
            state.setResponse(event.getResponse());
            return state;
        });
    }

    private void onEvent(LoadingFinishedEvent event) {
        requestState.computeIfPresent(event.getRequestId(), (requestId, state) -> {
            state.loadingFinished();
            return state;
        });
    }

    private void onEvent(LoadingFailedEvent event) {
        requestState.computeIfPresent(event.getRequestId(), (requestId, state) -> {
            state.loadingFailed(new CDPException(event.getErrorText()));
            return state;
        });
    }

    @RequiredArgsConstructor
    private static class RequestState {

        private final RequestId requestId;
        @Getter
        private final CompletableFuture<Response> loaded = new CompletableFuture<>();
        @Setter
        private Response response;

        public void loadingFailed(Throwable throwable) {
            loaded.completeExceptionally(throwable);
        }

        public void loadingFinished() {
            loaded.complete(response);
        }
    }
}
