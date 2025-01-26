package org.deripas.chrome.protocol.api.tethering.event;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Informs that port was successfully bound and got a specified connection id.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AcceptedEvent {
  public static final EventId<AcceptedEvent> ID = new EventId<>("Tethering.accepted", AcceptedEvent.class);

  /**
   * Port number that was successfully bound.
   */
  private final Integer port;

  /**
   * Connection id to be used.
   */
  private final String connectionId;
}
