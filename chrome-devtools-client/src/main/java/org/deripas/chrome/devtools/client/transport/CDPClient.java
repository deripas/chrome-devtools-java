package org.deripas.chrome.devtools.client.transport;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

public interface CDPClient {

    CompletableFuture<CDPTransport> http(URI httpUrl);

    CompletableFuture<CDPTransport> websocket(URI wsUrl);
}
