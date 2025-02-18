package io.github.deripas.chrome.devtools.api.network;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * WebSocket request data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketRequest {
  /**
   * HTTP request headers.
   */
  private final Headers headers;
}
