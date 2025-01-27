package org.deripas.chrome.devtools.client.transport;

import com.fasterxml.jackson.databind.JsonNode;
import org.deripas.chrome.devtools.client.Disposable;

import java.util.function.Consumer;

/**
 * Chrome DevTools Protocol transport.
 */
public interface CDPTransport {

    Disposable send(Request request, Consumer<Response> consumer);

    Disposable subscribe(String method, Consumer<Event> consumer);

    void close();

    record Request(
        Long id,
        String method,
        Object params,
        String sessionId
    ) {
    }

    interface Response {
        Long id();

        JsonNode result();

        Error error();
    }

    interface Event {
        String method();

        JsonNode params();
    }

    record Error(
        Long code,
        String message,
        JsonNode data
    ) {
    }
}
