package org.deripas.chrome.protocol.api.preload.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.preload.RuleSet;

/**
 * Upsert. Currently, it is only emitted when a rule set added.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RuleSetUpdatedEvent {
  public static final EventId<RuleSetUpdatedEvent> ID = new EventId<>("Preload.ruleSetUpdated", RuleSetUpdatedEvent.class);

  private final RuleSet ruleSet;
}
