package org.deripas.chrome.devtools.client.transport.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.deripas.chrome.devtools.client.transport.Request;
import org.deripas.chrome.devtools.client.transport.TransportCDP;

import java.net.http.WebSocket;

@Slf4j
@RequiredArgsConstructor
public class HttpTransportCDP implements TransportCDP {

    private final WebSocket webSocket;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public void send(Request request) {
        final String json = objectMapper.writeValueAsString(request);
        log.debug("Sending request: {}", json);
        webSocket.sendText(json, true);
    }
}
