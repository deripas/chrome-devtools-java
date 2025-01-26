package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.WebSocketFrame;

/**
 * Fired when WebSocket message is sent.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketFrameSentEvent {
  public static final EventId<WebSocketFrameSentEvent> ID = new EventId<>("Network.webSocketFrameSent", WebSocketFrameSentEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * WebSocket response data.
   */
  private final WebSocketFrame response;
}
