package org.deripas.chrome.protocol.api.dom.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Mirrors `DOMNodeRemoved` event.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ChildNodeRemovedEvent {
  public static final EventId<ChildNodeRemovedEvent> ID = new EventId<>("DOM.childNodeRemoved", ChildNodeRemovedEvent.class);

  /**
   * Parent id.
   */
  private final NodeId parentNodeId;

  /**
   * Id of the node that has been removed.
   */
  private final NodeId nodeId;
}
