package io.github.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.api.transport.Record;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.http.WebSocket;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class WebSocketListener implements WebSocket.Listener {

    private final ObjectMapper objectMapper;
    private final List<Consumer<Record>> consumers = new CopyOnWriteArrayList<>();
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        webSocket.request(1);

        buffer.append(data);
        if (last) {
            try {
                log.debug("<< {}", buffer.subSequence(0, Math.min(300, buffer.length())));
                final String json = buffer.toString();
                final Record record = parseRecord(json);
                consumers.forEach(consumer -> consumer.accept(record));
            } catch (Exception e) {
                log.error("Failed to parse response", e);
            } finally {
                buffer.setLength(0);
            }
        }
        return null;
    }

    public void subscribe(Consumer<Record> consumer) {
        consumers.add(consumer);
    }

    public void unsubscribe(Consumer<Record> consumer) {
        consumers.remove(consumer);
    }

    @SneakyThrows
    private Record parseRecord(String json) {
        return objectMapper.readValue(json, Record.class);
    }
}
