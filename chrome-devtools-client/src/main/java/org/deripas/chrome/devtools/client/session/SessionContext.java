package org.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.Disposable;
import org.deripas.chrome.devtools.client.transport.CDPTransport;
import org.deripas.chrome.protocol.api.EventId;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class SessionContext implements Disposable {

    private final CDPTransport transport;
    private final ObjectMapper objectMapper;
    private final AtomicLong idGenerator = new AtomicLong(0);
    private final AtomicReference<String> sessionId = new AtomicReference<>();

    @Override
    public void dispose() {
        transport.close();
    }

    public void setSessionId(String sessionIdValue) {
        sessionId.set(sessionIdValue);
    }

    public <T> Disposable subscribe(EventId<T> eventId, Consumer<T> consumer) {
        return transport.subscribe(eventId.method(), event -> {
            final JsonNode params = event.params();
            final T data = objectMapper.convertValue(params, eventId.type());
            consumer.accept(data);
        });
    }

    public <T> CompletableFuture<T> send(
        String methodName,
        Object argument,
        Class<T> responseType
    ) {
        final ResponseConsumer responseConsumer = new ResponseConsumer();
        final Disposable disposable = transport.send(
            request(methodName, argument),
            responseConsumer
        );
        return responseConsumer.getFuture()
            .thenApply(response -> parseResponse(response.result(), responseType))
            .whenComplete((r, e) -> disposable.dispose());
    }

    private <T> T parseResponse(JsonNode result, Class<T> responseType) {
        return objectMapper.convertValue(result, responseType);
    }

    private CDPTransport.Request request(String method, Object params) {
        return new CDPTransport.Request(
            idGenerator.incrementAndGet(),
            method,
            params,
            sessionId.get()
        );
    }
}
