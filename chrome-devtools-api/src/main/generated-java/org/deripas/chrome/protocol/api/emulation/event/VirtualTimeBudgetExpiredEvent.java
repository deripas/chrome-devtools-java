package org.deripas.chrome.protocol.api.emulation.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Notification sent after the virtual time budget for the current VirtualTimePolicy has run out.
 */
@Generated
public class VirtualTimeBudgetExpiredEvent {
  public static final EventId<VirtualTimeBudgetExpiredEvent> ID = new EventId<>("Emulation.virtualTimeBudgetExpired", VirtualTimeBudgetExpiredEvent.class);
}
