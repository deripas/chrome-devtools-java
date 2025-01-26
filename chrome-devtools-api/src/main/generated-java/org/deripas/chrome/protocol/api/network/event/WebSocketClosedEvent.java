package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when WebSocket is closed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketClosedEvent {
  public static final EventId<WebSocketClosedEvent> ID = new EventId<>("Network.webSocketClosed", WebSocketClosedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;
}
