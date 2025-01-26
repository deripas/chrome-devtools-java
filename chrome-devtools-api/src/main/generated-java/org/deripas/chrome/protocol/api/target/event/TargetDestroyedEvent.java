package org.deripas.chrome.protocol.api.target.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.TargetID;

/**
 * Issued when a target is destroyed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TargetDestroyedEvent {
  public static final EventId<TargetDestroyedEvent> ID = new EventId<>("Target.targetDestroyed", TargetDestroyedEvent.class);

  private final TargetID targetId;
}
