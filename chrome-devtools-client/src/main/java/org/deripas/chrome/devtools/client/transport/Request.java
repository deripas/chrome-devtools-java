package org.deripas.chrome.devtools.client.transport;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
    private final int id;
    private final String method;
    private final Object params;
    private final String sessionId;
}
