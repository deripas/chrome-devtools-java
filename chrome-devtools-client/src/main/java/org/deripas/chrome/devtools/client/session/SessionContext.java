package org.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.transport.CDPException;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class SessionContext {

    private final ObjectMapper objectMapper;
    private final AtomicLong idGenerator = new AtomicLong(0);
    private final AtomicReference<String> sessionId = new AtomicReference<>();

    public void setSessionId(String sessionIdValue) {
        sessionId.set(sessionIdValue);
    }

    public CDPTransport.Request request(String method, Object params) {
        return new CDPTransport.Request(
            idGenerator.incrementAndGet(),
            method,
            toMap(params),
            sessionId.get()
        );
    }

    public <T> CompletionStage<T> response(CDPTransport.Response response, Class<T> responseType) {
        final CompletableFuture<T> future = new CompletableFuture<>();
        try {
            final CDPTransport.Error error = response.error();
            if (error != null) {
                future.completeExceptionally(new CDPException(error));
            } else {
                final Map<String, Object> data = response.result();
                final T result = objectMapper.convertValue(data, responseType);
                future.complete(result);
            }
        } catch (Exception e) {
            future.completeExceptionally(e);
        }
        return future;
    }

    private Map<String, Object> toMap(Object params) {
        return objectMapper.convertValue(params, Map.class);
    }
}
