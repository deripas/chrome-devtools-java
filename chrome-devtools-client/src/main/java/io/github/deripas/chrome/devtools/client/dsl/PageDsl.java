package io.github.deripas.chrome.devtools.client.dsl;

import io.github.deripas.chrome.devtools.api.Protocol;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.emulation.Emulation;
import io.github.deripas.chrome.devtools.api.network.Headers;
import io.github.deripas.chrome.devtools.api.network.Network;
import io.github.deripas.chrome.devtools.api.network.RequestId;
import io.github.deripas.chrome.devtools.api.network.ResourceType;
import io.github.deripas.chrome.devtools.api.network.Response;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import io.github.deripas.chrome.devtools.api.page.Page;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
import io.github.deripas.chrome.devtools.api.runtime.Runtime;
import io.github.deripas.chrome.devtools.api.target.TargetID;

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
    private final Protocol protocol;

    private final Map<RequestId, RequestState> requestState;
    private final Map<FrameId, RequestId> documentRequestByFrame;
    private final Disposable disposable;

    public PageDsl(TargetID targetId, Protocol protocol, Consumer<PageDsl> closeCallback) {
        this.protocol = protocol;
        this.id = targetId;

        requestState = new ConcurrentHashMap<>();
        documentRequestByFrame = new ConcurrentHashMap<>();

        final Network network = protocol.getNetwork();
        final Page page = protocol.getPage();
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
        protocol.getEmulation()
            .setUserAgentOverride(Emulation.SetUserAgentOverrideRequest.builder()
                .userAgent(userAgent)
                .build())
            .join();
    }

    public void setLocale(String locale) {
        protocol.getEmulation()
            .setLocaleOverride(Emulation.SetLocaleOverrideRequest.builder()
                .locale(locale)
                .build())
            .join();
    }

    public void setGeolocation(double latitude, double longitude, double accuracy) {
        protocol.getEmulation()
            .setGeolocationOverride(Emulation.SetGeolocationOverrideRequest.builder()
                .latitude(latitude)
                .longitude(longitude)
                .accuracy(accuracy)
                .build())
            .join();
    }

    public void setExtraHeaders(Map<String, String> headers) {
        protocol.getNetwork()
            .setExtraHTTPHeaders(Network.SetExtraHTTPHeadersRequest.builder()
                .headers(Headers.of(headers))
                .build())
            .join();
    }

    public void configureDevice(Consumer<Emulation.SetDeviceMetricsOverrideRequest.SetDeviceMetricsOverrideRequestBuilder> configurer) {
        final Emulation.SetDeviceMetricsOverrideRequest.SetDeviceMetricsOverrideRequestBuilder builder = Emulation.SetDeviceMetricsOverrideRequest.builder();
        configurer.accept(builder);
        protocol.getEmulation()
            .setDeviceMetricsOverride(builder.build())
            .join();
    }

    @SneakyThrows
    public PageResponse navigate(String url) {
        return protocol.getPage()
            .stopLoading()
            .thenCompose(ignore -> protocol.getPage()
                .navigate(Page.NavigateRequest.builder()
                    .url(url)
                    .build())
                .thenCompose(this::toPageResponse))
            .join();
    }

    public byte[] screenshot(Page.CaptureScreenshotRequest.Format format) {
        return protocol.getPage()
            .captureScreenshot(Page.CaptureScreenshotRequest.builder()
                .format(format)
                .build())
            .thenApply(Page.CaptureScreenshotResponse::getData)
            .thenApply(data -> Base64.getDecoder().decode(data))
            .join();
    }

    public RemoteObject evaluate(String expression) {
        return protocol.getRuntime()
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
            return CompletableFuture.failedFuture(new RuntimeException(navigateResponse.getErrorText()));
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
        return protocol.getNetwork()
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
            state.loadingFailed(new RuntimeException(event.getErrorText()));
            return state;
        });
    }

    private void onEvent(Page.JavascriptDialogOpeningEvent event) {
        log.warn("Dialog opened: {}", event.getMessage());
        protocol.getPage()
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
