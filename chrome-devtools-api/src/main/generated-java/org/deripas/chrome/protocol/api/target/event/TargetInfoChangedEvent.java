package org.deripas.chrome.protocol.api.target.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.TargetInfo;

/**
 * Issued when some information about a target has changed. This only happens between
 * `targetCreated` and `targetDestroyed`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TargetInfoChangedEvent {
  public static final EventId<TargetInfoChangedEvent> ID = new EventId<>("Target.targetInfoChanged", TargetInfoChangedEvent.class);

  private final TargetInfo targetInfo;
}
