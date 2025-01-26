package org.deripas.chrome.protocol.api.inspector.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when debugging target has crashed
 */
@Generated
public class TargetCrashedEvent {
  public static final EventId<TargetCrashedEvent> ID = new EventId<>("Inspector.targetCrashed", TargetCrashedEvent.class);
}
