package org.deripas.chrome.protocol.api.inspector.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when debugging target has reloaded after crash
 */
@Generated
public class TargetReloadedAfterCrashEvent {
  public static final EventId<TargetReloadedAfterCrashEvent> ID = new EventId<>("Inspector.targetReloadedAfterCrash", TargetReloadedAfterCrashEvent.class);
}
