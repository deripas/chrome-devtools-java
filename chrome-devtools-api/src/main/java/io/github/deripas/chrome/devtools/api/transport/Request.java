package io.github.deripas.chrome.devtools.api.transport;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
    private Long id;
    private String method;
    private JsonNode params;
    private String sessionId;
}