package org.deripas.chrome.protocol.api.target.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.TargetInfo;

/**
 * Issued when a possible inspection target is created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TargetCreatedEvent {
  public static final EventId<TargetCreatedEvent> ID = new EventId<>("Target.targetCreated", TargetCreatedEvent.class);

  private final TargetInfo targetInfo;
}
