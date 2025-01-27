package org.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.Disposable;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

import java.net.http.WebSocket.Listener;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Slf4j
public class RecordListener {

    private final ObjectMapper objectMapper;
    private final Map<Long, Consumer<CDPTransport.Response>> responseListeners;
    private final Multimap<String, Consumer<CDPTransport.Event>> eventListeners;

    public RecordListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        responseListeners = new ConcurrentHashMap<>();
        eventListeners = MultimapBuilder.hashKeys()
            .arrayListValues()
            .build();
    }

    public Disposable subscribeResponse(Long id, Consumer<CDPTransport.Response> consumer) {
        log.debug("Subscribing to request with id: {}", id);
        responseListeners.put(id, consumer);
        return () -> responseListeners.remove(id);
    }

    public Disposable subscribeEvent(String method, Consumer<CDPTransport.Event> consumer) {
        eventListeners.put(method, consumer);
        return () -> eventListeners.remove(method, consumer);
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
            eventListeners.get(record.method())
                .forEach(consumer -> consumer.accept(record));
            return;
        }
        log.warn("Unknown record: {}", record);
    }
}
