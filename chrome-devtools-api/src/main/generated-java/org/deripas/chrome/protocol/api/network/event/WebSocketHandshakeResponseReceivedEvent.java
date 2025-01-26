package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.WebSocketResponse;

/**
 * Fired when WebSocket handshake response becomes available.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketHandshakeResponseReceivedEvent {
  public static final EventId<WebSocketHandshakeResponseReceivedEvent> ID = new EventId<>("Network.webSocketHandshakeResponseReceived", WebSocketHandshakeResponseReceivedEvent.class);

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
  private final WebSocketResponse response;
}
