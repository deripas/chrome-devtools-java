package org.deripas.chrome.protocol.api.accessibility.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.accessibility.AXNode;

/**
 * The nodesUpdated event is sent every time a previously requested node has changed the in tree.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodesUpdatedEvent {
  public static final EventId<NodesUpdatedEvent> ID = new EventId<>("Accessibility.nodesUpdated", NodesUpdatedEvent.class);

  /**
   * Updated node data.
   */
  private final List<AXNode> nodes;
}
