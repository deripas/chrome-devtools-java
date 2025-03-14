package io.github.deripas.chrome.devtools.api.session;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.transport.Event;
import io.github.deripas.chrome.devtools.api.transport.Record;
import io.github.deripas.chrome.devtools.api.transport.Request;
import io.github.deripas.chrome.devtools.api.transport.Response;
import io.github.deripas.chrome.devtools.api.Transport;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

@Slf4j
public abstract class BaseSession implements Session {

    private static final Consumer<Response> EMPTY_CONSUMER = response -> {
        // do nothing
    };
    private static final List<Consumer<Event>> EMPTY_CONSUMERS = Collections.emptyList();

    protected final Transport transport;
    protected final ObjectMapper objectMapper;
    protected final AtomicLong idGenerator;
    protected final String sessionId;

    private final Map<Long, Consumer<Response>> responseListeners;
    private final Map<String, List<Consumer<Event>>> eventListeners;
    private final Disposable disposable;

    public BaseSession(
        Transport transport,
        ObjectMapper objectMapper,
        AtomicLong idGenerator,
        String sessionId
    ) {
        this.transport = transport;
        this.objectMapper = objectMapper;
        this.idGenerator = idGenerator;
        this.sessionId = sessionId;

        responseListeners = new ConcurrentHashMap<>();
        eventListeners = new ConcurrentHashMap<>();
        disposable = transport.subscribe(this::handle);
    }

    @Override
    public <T> CompletableFuture<T> send(String method, Object argument, Class<T> responseType) {
        final Request request = toRequest(method, argument);
        final Long id = request.getId();
        final CompletableFuture<T> future = new CompletableFuture<>();
        responseListeners.put(id, response -> {
            try {
                if (response instanceof Response.Failed failed) {
                    future.completeExceptionally(failed.toException());
                    return;
                }
                if (response instanceof Response.Success success) {
                    final T value = objectMapper.convertValue(success.getResult(), responseType);
                    future.complete(value);
                    return;
                }
                future.completeExceptionally(new IllegalArgumentException());
            } catch (Exception e) {
                future.completeExceptionally(e);
            } finally {
                responseListeners.remove(id);
            }
        });
        transport.send(request);
        return future;
    }

    @Override
    public <T> Disposable subscribe(String method, Consumer<T> eventConsumer, Class<T> eventType) {
        final Consumer<Event> consumer = event -> {
            try {
                final JsonNode params = event.getParams();
                final T data = objectMapper.convertValue(params, eventType);
                eventConsumer.accept(data);
            } catch (Exception e) {
                log.error("Failed to convert event {}", event, e);
            }
        };
        final List<Consumer<Event>> consumers = eventListeners.computeIfAbsent(method, key -> new CopyOnWriteArrayList<>());
        consumers.add(consumer);
        return () -> consumers.remove(consumer);
    }

    @Override
    public void close() {
        disposable.dispose();
        responseListeners.clear();
        eventListeners.clear();
    }

    private void handle(Record record) {
        if (record instanceof Response response) {
            responseListeners.getOrDefault(response.getId(), EMPTY_CONSUMER)
                .accept(response);
            return;
        }
        if (record instanceof Event event && Objects.equals(event.getSessionId(), sessionId)) {
            eventListeners.getOrDefault(event.getMethod(), EMPTY_CONSUMERS)
                .forEach(eventConsumer -> eventConsumer.accept(event));
            return;
        }
        log.warn("Unhandled record {}", record);
    }

    private Request toRequest(String method, Object argument) {
        return Request.builder()
            .id(idGenerator.incrementAndGet())
            .method(method)
            .params(objectMapper.valueToTree(argument))
            .sessionId(sessionId)
            .build();
    }
}
