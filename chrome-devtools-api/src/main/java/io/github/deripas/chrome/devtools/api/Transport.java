package io.github.deripas.chrome.devtools.api;

import io.github.deripas.chrome.devtools.api.transport.Record;
import io.github.deripas.chrome.devtools.api.transport.Request;

import java.util.function.Consumer;

/**
 * Chrome DevTools Protocol transport.
 */
public interface Transport {

    void send(Request request);

    Disposable subscribe(Consumer<Record> handler);

    void close();
}
