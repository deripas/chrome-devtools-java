package org.deripas.chrome.protocol.api.dom.event;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when a node's scrollability state changes.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScrollableFlagUpdatedEvent {
  public static final EventId<ScrollableFlagUpdatedEvent> ID = new EventId<>("DOM.scrollableFlagUpdated", ScrollableFlagUpdatedEvent.class);

  /**
   * The id of the node.
   */
  private final NodeId nodeId;

  /**
   * If the node is scrollable.
   */
  private final Boolean isScrollable;
}
