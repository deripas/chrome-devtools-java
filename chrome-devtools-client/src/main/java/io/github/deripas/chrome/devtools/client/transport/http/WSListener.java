package io.github.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public class WSListener implements WebSocket.Listener {

    private final ObjectMapper objectMapper;
    private final Consumer<WSRecord> consumer;

    private final StringBuilder buffer = new StringBuilder();

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        webSocket.request(1);

        buffer.append(data);
        if (last) {
            try {
                log.debug("<< {}", buffer.subSequence(0, Math.min(300, buffer.length())));
                final WSRecord record = parseRecord(buffer);
                consumer.accept(record);
            } catch (Exception e) {
                log.error("Failed to parse response", e);
            } finally {
                buffer.setLength(0);
            }
        }
        return null;
    }

    @SneakyThrows
    private WSRecord parseRecord(StringBuilder buffer) {
        return objectMapper.readValue(buffer.toString(), WSRecord.class);
    }
}
