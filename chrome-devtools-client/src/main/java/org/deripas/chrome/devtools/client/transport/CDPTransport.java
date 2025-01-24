package org.deripas.chrome.devtools.client.transport;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Chrome DevTools Protocol transport.
 */
public interface CDPTransport {

    CompletableFuture<Response> ask(Request request);

    void close();

    record Request(
        Long id,
        String method,
        Map<String, Object> params,
        String sessionId
    ) {
    }

    record Response(
        Long id,
        Map<String, Object> result,
        Error error
    ) {
    }

    record Error(
        Long code,
        String message,
        Map<String, Object> data
    ) {
    }
}
