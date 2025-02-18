package io.github.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.github.deripas.chrome.devtools.client.CDPTransport;
import io.github.deripas.chrome.devtools.api.Disposable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public abstract class SessionContext implements Disposable {

    private final CDPTransport transport;
    private final ObjectMapper objectMapper;
    private final AtomicLong idGenerator;
    private final String sessionId;

    public SessionContext withSessionId(String sessionId) {
        return new SessionContext.Child(this, sessionId);
    }

    public <T> Disposable subscribe(String method, Class<T> type, Consumer<T> consumer) {
        return transport.subscribe(method, event -> {
            if (Objects.equals(event.sessionId(), sessionId)) {
                final JsonNode params = event.params();
                final T data = objectMapper.convertValue(params, type);
                consumer.accept(data);
            }
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
            sessionId
        );
    }

    static class Root extends SessionContext {

        private final CDPTransport transport;

        public Root(CDPTransport transport, ObjectMapper objectMapper) {
            super(transport, objectMapper, new AtomicLong(), null);
            this.transport = transport;
        }

        @Override
        public void dispose() {
            log.info("dispose root session");
            transport.close();
        }
    }

    static class Child extends SessionContext {

        public Child(SessionContext root, String sessionId) {
            super(root.transport, root.objectMapper, root.idGenerator, sessionId);
        }

        @Override
        public void dispose() {
            log.warn("child session cannot be disposed");
        }
    }
}
