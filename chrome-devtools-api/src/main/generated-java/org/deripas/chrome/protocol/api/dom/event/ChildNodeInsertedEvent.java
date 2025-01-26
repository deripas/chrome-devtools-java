package org.deripas.chrome.protocol.api.dom.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.Node;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Mirrors `DOMNodeInserted` event.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ChildNodeInsertedEvent {
  public static final EventId<ChildNodeInsertedEvent> ID = new EventId<>("DOM.childNodeInserted", ChildNodeInsertedEvent.class);

  /**
   * Id of the node that has changed.
   */
  private final NodeId parentNodeId;

  /**
   * Id of the previous sibling.
   */
  private final NodeId previousNodeId;

  /**
   * Inserted node data.
   */
  private final Node node;
}
