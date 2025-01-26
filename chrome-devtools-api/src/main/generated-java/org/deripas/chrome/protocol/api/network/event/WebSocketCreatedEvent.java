package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.Initiator;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired upon WebSocket creation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebSocketCreatedEvent {
  public static final EventId<WebSocketCreatedEvent> ID = new EventId<>("Network.webSocketCreated", WebSocketCreatedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * WebSocket request URL.
   */
  private final String url;

  /**
   * Request initiator.
   */
  @Nullable
  private final Initiator initiator;
}
