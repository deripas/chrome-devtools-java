package org.deripas.chrome.protocol.api.network;

import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * WebSocket response data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketResponse {
  /**
   * HTTP response status code.
   */
  private final Integer status;

  /**
   * HTTP response status text.
   */
  private final String statusText;

  /**
   * HTTP response headers.
   */
  private final Headers headers;

  /**
   * HTTP response headers text.
   */
  @Nullable
  private final String headersText;

  /**
   * HTTP request headers.
   */
  @Nullable
  private final Headers requestHeaders;

  /**
   * HTTP request headers text.
   */
  @Nullable
  private final String requestHeadersText;
}
