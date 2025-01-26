package org.deripas.chrome.protocol.api.preload.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.preload.RuleSetId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class RuleSetRemovedEvent {
  public static final EventId<RuleSetRemovedEvent> ID = new EventId<>("Preload.ruleSetRemoved", RuleSetRemovedEvent.class);

  private final RuleSetId id;
}
