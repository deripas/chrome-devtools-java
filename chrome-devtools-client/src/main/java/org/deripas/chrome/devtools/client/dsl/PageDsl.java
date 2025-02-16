package org.deripas.chrome.devtools.client.dsl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.CDPException;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.protocol.api.Disposable;
import org.deripas.chrome.protocol.api.emulation.Emulation;
import org.deripas.chrome.protocol.api.network.Headers;
import org.deripas.chrome.protocol.api.network.Network;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.network.Response;
import org.deripas.chrome.protocol.api.page.FrameId;
import org.deripas.chrome.protocol.api.page.Page;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;
import org.deripas.chrome.protocol.api.runtime.Runtime;
import org.deripas.chrome.protocol.api.target.TargetID;

import java.io.Closeable;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkState;

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

        final Network network = session.getNetwork();
        final Page page = session.getPage();
        final List<Disposable> disposables = List.of(
            network.onRequestWillBeSent(this::onEvent),
            network.onResponseReceived(this::onEvent),
            network.onLoadingFinished(this::onEvent),
            network.onLoadingFailed(this::onEvent),
            page.onJavascriptDialogOpening(this::onEvent)
        );
        disposable = () -> {
            disposables.forEach(Disposable::dispose);
            requestState.clear();
            documentRequestByFrame.clear();
            closeCallback.accept(this);
        };
    }

    public void setUserAgent(String userAgent) {
        session.getEmulation()
            .setUserAgentOverride(Emulation.SetUserAgentOverrideRequest.builder()
                .userAgent(userAgent)
                .build())
            .join();
    }

    public void setLocale(String locale) {
        session.getEmulation()
            .setLocaleOverride(Emulation.SetLocaleOverrideRequest.builder()
                .locale(locale)
                .build())
            .join();
    }

    public void setGeolocation(double latitude, double longitude, double accuracy) {
        session.getEmulation()
            .setGeolocationOverride(Emulation.SetGeolocationOverrideRequest.builder()
                .latitude(latitude)
                .longitude(longitude)
                .accuracy(accuracy)
                .build())
            .join();
    }

    public void setExtraHeaders(Map<String, String> headers) {
        session.getNetwork()
            .setExtraHTTPHeaders(Network.SetExtraHTTPHeadersRequest.builder()
                .headers(Headers.of(headers))
                .build())
            .join();
    }

    public void configureDevice(Consumer<Emulation.SetDeviceMetricsOverrideRequest.SetDeviceMetricsOverrideRequestBuilder> configurer) {
        final Emulation.SetDeviceMetricsOverrideRequest.SetDeviceMetricsOverrideRequestBuilder builder = Emulation.SetDeviceMetricsOverrideRequest.builder();
        configurer.accept(builder);
        session.getEmulation()
            .setDeviceMetricsOverride(builder.build())
            .join();
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

    public RemoteObject evaluate(String expression) {
        return session.getRuntime()
            .evaluate(Runtime.EvaluateRequest.builder()
                .expression(expression)
                .build())
            .thenApply(Runtime.EvaluateResponse::getResult)
            .join();
    }

    public String outerHTML() {
        final RemoteObject object = evaluate("document.documentElement.outerHTML");
        checkState(object.getType() == RemoteObject.Type.STRING);
        checkState(object.getValue() instanceof String);
        return object.getValue().toString();
    }

    public void click(String selector) {
        evaluate(String.format("document.querySelector('%s').click()", selector));
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

    private void onEvent(Network.RequestWillBeSentEvent event) {
        if (event.getType() == ResourceType.DOCUMENT
            && event.getRequest().getUrl().equals(event.getDocumentURL())) {
            requestState.computeIfAbsent(event.getRequestId(), RequestState::new);
            documentRequestByFrame.put(event.getFrameId(), event.getRequestId());
        }
    }

    private void onEvent(Network.ResponseReceivedEvent event) {
        requestState.computeIfPresent(event.getRequestId(), (requestId, state) -> {
            state.setResponse(event.getResponse());
            return state;
        });
    }

    private void onEvent(Network.LoadingFinishedEvent event) {
        requestState.computeIfPresent(event.getRequestId(), (requestId, state) -> {
            state.loadingFinished();
            return state;
        });
    }

    private void onEvent(Network.LoadingFailedEvent event) {
        requestState.computeIfPresent(event.getRequestId(), (requestId, state) -> {
            state.loadingFailed(new CDPException(event.getErrorText()));
            return state;
        });
    }

    private void onEvent(Page.JavascriptDialogOpeningEvent event) {
        log.warn("Dialog opened: {}", event.getMessage());
        session.getPage()
            .handleJavaScriptDialog(Page.HandleJavaScriptDialogRequest.builder()
                .accept(true)
                .build());
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
