package org.deripas.chrome.devtools.client.transport.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.deripas.chrome.devtools.client.transport.ClientCDP;
import org.deripas.chrome.devtools.client.transport.TransportCDP;
import org.deripas.chrome.devtools.client.transport.Version;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class HttpClientCDP implements ClientCDP {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Override
    public CompletableFuture<TransportCDP> http(URI httpUrl) {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(httpUrl.resolve("/json/version"))
            .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenApply(this::parseVersion)
            .thenCompose(version -> websocket(version.webSocketDebuggerUrl()));
    }

    @Override
    public CompletableFuture<TransportCDP> websocket(URI wsUrl) {
        return httpClient.newWebSocketBuilder()
            .buildAsync(wsUrl, new DevToolsListener())
            .thenApply(webSocket -> {
                return new HttpTransportCDP(webSocket, objectMapper);
            });
    }

    @SneakyThrows
    private Version parseVersion(String json) {
        return objectMapper.readValue(json, Version.class);
    }
}
