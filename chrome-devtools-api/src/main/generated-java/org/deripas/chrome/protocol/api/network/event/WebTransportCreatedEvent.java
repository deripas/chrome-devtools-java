package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.Initiator;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired upon WebTransport creation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WebTransportCreatedEvent {
  public static final EventId<WebTransportCreatedEvent> ID = new EventId<>("Network.webTransportCreated", WebTransportCreatedEvent.class);

  /**
   * WebTransport identifier.
   */
  private final RequestId transportId;

  /**
   * WebTransport request URL.
   */
  private final String url;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Request initiator.
   */
  @Nullable
  private final Initiator initiator;
}
