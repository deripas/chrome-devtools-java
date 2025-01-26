package org.deripas.chrome.protocol.api.debugger.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when the virtual machine resumed execution.
 */
@Generated
public class ResumedEvent {
  public static final EventId<ResumedEvent> ID = new EventId<>("Debugger.resumed", ResumedEvent.class);
}
