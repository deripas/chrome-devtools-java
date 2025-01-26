package org.deripas.chrome.protocol.api.network.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired once security policy has been updated.
 */
@Generated
public class PolicyUpdatedEvent {
  public static final EventId<PolicyUpdatedEvent> ID = new EventId<>("Network.policyUpdated", PolicyUpdatedEvent.class);
}
