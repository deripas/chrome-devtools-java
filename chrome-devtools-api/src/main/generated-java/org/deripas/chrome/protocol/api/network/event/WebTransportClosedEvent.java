package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when WebTransport is disposed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebTransportClosedEvent {
  public static final EventId<WebTransportClosedEvent> ID = new EventId<>("Network.webTransportClosed", WebTransportClosedEvent.class);

  /**
   * WebTransport identifier.
   */
  private final RequestId transportId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;
}
