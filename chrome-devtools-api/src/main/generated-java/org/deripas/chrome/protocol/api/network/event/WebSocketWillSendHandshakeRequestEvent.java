package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;
import org.deripas.chrome.protocol.api.network.WebSocketRequest;

/**
 * Fired when WebSocket is about to initiate handshake.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketWillSendHandshakeRequestEvent {
  public static final EventId<WebSocketWillSendHandshakeRequestEvent> ID = new EventId<>("Network.webSocketWillSendHandshakeRequest", WebSocketWillSendHandshakeRequestEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * UTC Timestamp.
   */
  private final TimeSinceEpoch wallTime;

  /**
   * WebSocket request data.
   */
  private final WebSocketRequest request;
}
