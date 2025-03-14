package io.github.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.transport.Record;
import io.github.deripas.chrome.devtools.api.transport.Request;
import io.github.deripas.chrome.devtools.api.Transport;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.http.WebSocket;
import java.util.function.Consumer;

/**
 * Java HttpClient based implementation of {@link Transport}.
 */
@Slf4j
@RequiredArgsConstructor
public class WebSocketTransport implements Transport {

    private final WebSocket webSocket;
    private final WebSocketListener listener;
    private final ObjectMapper objectMapper;

    @Override
    public void send(Request request) {
        final String json = toJson(request);
        log.debug(">> {}", json);
        webSocket.sendText(json, true);
    }

    @Override
    public Disposable subscribe(Consumer<Record> handler) {
        listener.subscribe(handler);
        return () -> listener.unsubscribe(handler);
    }

    @SneakyThrows
    @Override
    public void close() {
        log.debug("Closing connection");
        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "Close connection")
            .get();
    }

    @SneakyThrows
    private String toJson(Request request) {
        return objectMapper.writeValueAsString(request);
    }
}
