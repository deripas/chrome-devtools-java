package org.deripas.chrome.protocol.api.css.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ComputedStyleUpdatedEvent {
  public static final EventId<ComputedStyleUpdatedEvent> ID = new EventId<>("CSS.computedStyleUpdated", ComputedStyleUpdatedEvent.class);

  /**
   * The node id that has updated computed styles.
   */
  private final NodeId nodeId;
}
