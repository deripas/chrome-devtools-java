package io.github.deripas.chrome.devtools.api;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Represents a connection to a Chrome DevTools Protocol endpoint.
 */
public interface Session {

    <T> CompletableFuture<T> send(
        String method,
        Object argument,
        Class<T> responseType
    );

    <T> Disposable subscribe(
        String method,
        Consumer<T> eventConsumer,
        Class<T> eventType
    );

    Session withSessionId(String sessionId);

    void close();
}
