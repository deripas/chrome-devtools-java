package org.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.Disposable;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import java.net.http.WebSocket.Listener;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

@Slf4j
public class RecordListener {

    private final ObjectMapper objectMapper;
    private final Map<Long, Consumer<CDPTransport.Response>> responseListeners;
    private final Map<String, List<Consumer<CDPTransport.Event>>> eventListeners;

    public RecordListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        responseListeners = new ConcurrentHashMap<>();
        eventListeners = new ConcurrentHashMap<>();
    }

    public Disposable subscribeResponse(Long id, Consumer<CDPTransport.Response> consumer) {
        responseListeners.put(id, consumer);
        return () -> responseListeners.remove(id);
    }

    public Disposable subscribeEvent(String method, Consumer<CDPTransport.Event> consumer) {
        final List<Consumer<CDPTransport.Event>> consumers = eventListeners.computeIfAbsent(method, k -> new CopyOnWriteArrayList<>());
        consumers.add(consumer);
        return () -> consumers.remove(consumer);
    }

    public Listener createWebSocketListener() {
        return new WSListener(
            objectMapper,
            this::fireRecord
        );
    }

    public void close() {
        eventListeners.clear();
        responseListeners.clear();
    }

    private void fireRecord(WSRecord record) {
        final Long id = record.id();
        if (id != null) {
            Optional.ofNullable(responseListeners.remove(id))
                .ifPresent(consumer -> consumer.accept(record));
            return;
        }
        if (record.method() != null) {
            eventListeners.getOrDefault(record.method(), Collections.emptyList())
                .forEach(consumer -> consumer.accept(record));
            return;
        }
        log.warn("Unknown record: {}", record);
    }
}
