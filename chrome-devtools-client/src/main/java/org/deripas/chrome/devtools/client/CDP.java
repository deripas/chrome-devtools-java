package org.deripas.chrome.devtools.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.transport.factory.Factory;
import org.deripas.chrome.devtools.client.transport.ClientCDP;
import org.deripas.chrome.devtools.client.transport.impl.HttpClientCDP;
import org.deripas.chrome.protocol.api.Protocol;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
public class CDP {

    private final ClientCDP client;
    private final Factory factory;

    public static CDP create() {
        final HttpClient httpClient = HttpClient.newHttpClient();
        final ObjectMapper objectMapper = new ObjectMapper();
        final ClientCDP client = new HttpClientCDP(httpClient, objectMapper);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new CDP(client, new Factory());
    }

    public CompletableFuture<Protocol> http(URI httpUrl) {
        return client.http(httpUrl)
            .thenApply(factory::createProtocol);
    }

    public CompletableFuture<Protocol> websocket(URI wsUrl) {
        return client.websocket(wsUrl)
            .thenApply(factory::createProtocol);
    }
}
