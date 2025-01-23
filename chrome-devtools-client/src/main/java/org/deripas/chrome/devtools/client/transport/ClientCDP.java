package org.deripas.chrome.devtools.client.transport;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

public interface ClientCDP {

    CompletableFuture<TransportCDP> http(URI httpUrl);

    CompletableFuture<TransportCDP> websocket(URI wsUrl);
}
