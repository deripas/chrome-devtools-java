package io.github.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.devtools.client.CDPClient;
import io.github.deripas.chrome.devtools.client.CDPTransport;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * Java HttpClient based implementation of {@link CDPClient}.
 */
@Slf4j
@RequiredArgsConstructor
public class HttpCDPClient implements CDPClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Override
    public CompletableFuture<CDPTransport> http(URI httpUrl) {
        final HttpRequest request = HttpRequest.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .uri(httpUrl.resolve("/json/version"))
            .header("Accept-Encoding", "gzip, deflate, br")
            .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenApply(this::parseVersion)
            .thenCompose(version -> websocket(version.webSocketDebuggerUrl()));
    }

    @Override
    public CompletableFuture<CDPTransport> websocket(URI wsUrl) {
        log.debug("Connecting to {}", wsUrl);
        final RecordListener listener = new RecordListener(objectMapper);
        return httpClient.newWebSocketBuilder()
            .buildAsync(wsUrl, listener.createWebSocketListener())
            .thenApply(webSocket -> new HttpCDPTransport(webSocket, listener, objectMapper));
    }

    @SneakyThrows
    private Version parseVersion(String json) {
        return objectMapper.readValue(json, Version.class);
    }

    private record Version(
        @JsonProperty("Browser") String browser,
        @JsonProperty("Protocol-Version") String protocolVersion,
        @JsonProperty("User-Agent") String userAgent,
        @JsonProperty("V8-Version") String v8Version,
        @JsonProperty("WebKit-Version") String webKitVersion,
        @JsonProperty("webSocketDebuggerUrl") URI webSocketDebuggerUrl
    ) {
    }
}
