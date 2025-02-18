package io.github.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.devtools.client.CDPTransport;
import io.github.deripas.chrome.devtools.api.Disposable;

import java.net.http.WebSocket;
import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Java HttpClient based implementation of {@link CDPTransport}.
 */
@Slf4j
@RequiredArgsConstructor
public class HttpCDPTransport implements CDPTransport {

    private final WebSocket webSocket;
    private final RecordListener listener;
    private final ObjectMapper objectMapper;

    @Override
    public Disposable send(Request request, Consumer<Response> consumer) {
        checkArgument(request.id() != null, "Request id must be set");
        final Disposable disposable = listener.subscribeResponse(request.id(), consumer);
        final String json = toJson(request);
        log.debug(">> {}", json);
        webSocket.sendText(json, true);
        return disposable;
    }

    @Override
    public Disposable subscribe(String method, Consumer<Event> consumer) {
        return listener.subscribeEvent(method, consumer);
    }

    @SneakyThrows
    @Override
    public void close() {
        log.debug("Closing connection");
        listener.close();
        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "Close connection")
            .get();
    }

    @SneakyThrows
    private String toJson(Request request) {
        return objectMapper.writeValueAsString(request);
    }
}
