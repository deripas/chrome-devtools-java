package org.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Java HttpClient based implementation of {@link CDPTransport}.
 */
@Slf4j
@RequiredArgsConstructor
public class HttpCDPTransport implements CDPTransport {

    private final WebSocket webSocket;
    private final ResponseListener listener;
    private final ObjectMapper objectMapper;

    @Override
    public CompletableFuture<Response> ask(Request request) {
        checkArgument(request.id() != null, "Request id must be set");
        final CompletableFuture<Response> future = new CompletableFuture<>();
        listener.subscribe(request.id(), future);
        send(request);
        return future;
    }

    @SneakyThrows
    @Override
    public void close() {
        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "Close connection");
        listener.closeFuture().get();
    }

    @SneakyThrows
    private void send(Request request) {
        final String json = objectMapper.writeValueAsString(request);
        log.debug(">> {}", json);
        webSocket.sendText(json, true);
    }
}
