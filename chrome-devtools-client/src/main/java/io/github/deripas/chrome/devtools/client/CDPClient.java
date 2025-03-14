package io.github.deripas.chrome.devtools.client;

import io.github.deripas.chrome.devtools.api.Transport;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

public interface CDPClient {

    CompletableFuture<Transport> http(URI httpUrl);

    CompletableFuture<Transport> websocket(URI wsUrl);
}
