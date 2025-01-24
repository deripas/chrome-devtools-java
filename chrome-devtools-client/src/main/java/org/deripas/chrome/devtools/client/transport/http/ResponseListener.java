package org.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import com.github.benmanes.caffeine.cache.Scheduler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ResponseListener {

    private final ObjectMapper objectMapper;
    private final Cache<Long, CompletableFuture<CDPTransport.Response>> subscribers;
    private final CompletableFuture<Void> closeFuture = new CompletableFuture<>();

    public ResponseListener(ObjectMapper objectMapper, Duration rpcTimeout) {
        this.objectMapper = objectMapper;
        subscribers = Caffeine.newBuilder()
            .expireAfterWrite(rpcTimeout)
            .scheduler(Scheduler.systemScheduler())
            .removalListener((RemovalListener<Long, CompletableFuture<CDPTransport.Response>>) (key, value, cause) -> {
                if (cause == RemovalCause.EXPIRED && value != null) {
                    value.completeExceptionally(new TimeoutException("RPC timeout"));
                }
            })
            .build();
    }

    public void subscribe(Long id, CompletableFuture<CDPTransport.Response> future) {
        log.debug("Subscribing to request with id: {}", id);
        subscribers.put(id, future);
    }

    public CompletableFuture<Void> closeFuture() {
        return closeFuture;
    }

    @SneakyThrows
    private CDPTransport.Response parseResponse(CharSequence data) {
        return objectMapper.readValue(data.toString(), CDPTransport.Response.class);
    }

    private void fireResponse(CDPTransport.Response response) {
        final Long id = response.id();
        if (id == null) {
            return;
        }

        final CompletableFuture<CDPTransport.Response> future = subscribers.getIfPresent(id);
        if (future != null) {
            future.complete(response);
            subscribers.invalidate(id);
        }
    }

    private void fireException(Throwable throwable) {
        subscribers.asMap().values()
            .forEach(future -> future.completeExceptionally(throwable));
        subscribers.invalidateAll();
    }

    public Listener createWebsocketListener() {
        return new Listener() {
            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                log.debug("<< {}", data);
                webSocket.request(1);
                final CDPTransport.Response response = parseResponse(data);
                fireResponse(response);
                return null;
            }

            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                log.info("WebSocket connection closed: {} {}", statusCode, reason);
                fireException(new IllegalStateException("WebSocket connection closed"));
                closeFuture.complete(null);
                return Listener.super.onClose(webSocket, statusCode, reason);
            }

            @Override
            public void onError(WebSocket webSocket, Throwable error) {
                log.error("WebSocket error", error);
                fireException(error);
                Listener.super.onError(webSocket, error);
            }
        };
    }
}
