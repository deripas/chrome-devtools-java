package org.deripas.chrome.protocol.api.dom.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.Node;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon
 * most of the calls requesting node ids.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SetChildNodesEvent {
  public static final EventId<SetChildNodesEvent> ID = new EventId<>("DOM.setChildNodes", SetChildNodesEvent.class);

  /**
   * Parent node id to populate with children.
   */
  private final NodeId parentId;

  /**
   * Child nodes array.
   */
  private final List<Node> nodes;
}
