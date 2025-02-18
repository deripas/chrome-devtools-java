package io.github.deripas.chrome.devtools.client;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.deripas.chrome.devtools.api.Disposable;

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

        String sessionId();
    }

    record Error(
        Long code,
        String message,
        JsonNode data
    ) {
    }
}
