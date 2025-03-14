package io.github.deripas.chrome.devtools.api.transport;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class Event implements Record {
    private String method;
    private JsonNode params;
    private String sessionId;
}