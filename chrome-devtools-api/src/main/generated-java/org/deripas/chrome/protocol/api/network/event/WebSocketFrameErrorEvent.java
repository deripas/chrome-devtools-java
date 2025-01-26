package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when WebSocket message error occurs.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketFrameErrorEvent {
  public static final EventId<WebSocketFrameErrorEvent> ID = new EventId<>("Network.webSocketFrameError", WebSocketFrameErrorEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * WebSocket error message.
   */
  private final String errorMessage;
}
