package org.deripas.chrome.devtools.client.transport;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public record Version(
    @JsonProperty("Browser") String browser,
    @JsonProperty("Protocol-Version") String protocolVersion,
    @JsonProperty("User-Agent") String userAgent,
    @JsonProperty("V8-Version") String v8Version,
    @JsonProperty("WebKit-Version") String webKitVersion,
    @JsonProperty("webSocketDebuggerUrl") URI webSocketDebuggerUrl
) {
}
