package org.deripas.chrome.protocol.api.inspector.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DetachedEvent {
  public static final EventId<DetachedEvent> ID = new EventId<>("Inspector.detached", DetachedEvent.class);

  /**
   * The reason why connection has been terminated.
   */
  private final String reason;
}
