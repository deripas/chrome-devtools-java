package org.deripas.chrome.protocol.api.dom.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when `Element`'s inline style is modified via a CSS property modification.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InlineStyleInvalidatedEvent {
  public static final EventId<InlineStyleInvalidatedEvent> ID = new EventId<>("DOM.inlineStyleInvalidated", InlineStyleInvalidatedEvent.class);

  /**
   * Ids of the nodes for which the inline styles have been invalidated.
   */
  private final List<NodeId> nodeIds;
}
