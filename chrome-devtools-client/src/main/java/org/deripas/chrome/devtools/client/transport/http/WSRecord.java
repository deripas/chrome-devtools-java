package org.deripas.chrome.devtools.client.transport.http;

import com.fasterxml.jackson.databind.JsonNode;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

public record WSRecord(
    Long id,
    String method,
    JsonNode result,
    JsonNode params,
    CDPTransport.Error error
) implements CDPTransport.Response, CDPTransport.Event {
}
