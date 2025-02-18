package io.github.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.deripas.chrome.devtools.client.CDPTransport;

public record WSRecord(
    Long id,
    String method,
    JsonNode result,
    JsonNode params,
    String sessionId,
    CDPTransport.Error error
) implements CDPTransport.Response, CDPTransport.Event {
}
