package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when WebTransport handshake is finished.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebTransportConnectionEstablishedEvent {
  public static final EventId<WebTransportConnectionEstablishedEvent> ID = new EventId<>("Network.webTransportConnectionEstablished", WebTransportConnectionEstablishedEvent.class);

  /**
   * WebTransport identifier.
   */
  private final RequestId transportId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;
}
