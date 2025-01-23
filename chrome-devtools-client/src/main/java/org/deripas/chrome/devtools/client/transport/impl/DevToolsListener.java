package org.deripas.chrome.devtools.client.transport.impl;

import lombok.extern.slf4j.Slf4j;

import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletionStage;

@Slf4j
public class DevToolsListener implements Listener {

    @Override
    public void onOpen(WebSocket webSocket) {
        log.info("WebSocket connection opened");
        webSocket.request(1);
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        log.info("Received message: {}", data);
        webSocket.request(1);
        return Listener.super.onText(webSocket, data, last);
    }

    @Override
    public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
        log.info("Received binary message: {}", data);
        webSocket.request(1);
        return Listener.super.onBinary(webSocket, data, last);
    }

    @Override
    public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
        log.info("Received ping: {}", message);
        webSocket.request(1);
        return Listener.super.onPing(webSocket, message);
    }

    @Override
    public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
        log.info("Received pong: {}", message);
        webSocket.request(1);
        return Listener.super.onPong(webSocket, message);
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        log.info("WebSocket connection closed: {} {}", statusCode, reason);
        return Listener.super.onClose(webSocket, statusCode, reason);
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
        log.error("WebSocket error", error);
        Listener.super.onError(webSocket, error);
    }
}
