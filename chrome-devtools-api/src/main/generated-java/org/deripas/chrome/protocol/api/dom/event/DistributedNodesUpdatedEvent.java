package org.deripas.chrome.protocol.api.dom.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.BackendNode;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Called when distribution is changed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DistributedNodesUpdatedEvent {
  public static final EventId<DistributedNodesUpdatedEvent> ID = new EventId<>("DOM.distributedNodesUpdated", DistributedNodesUpdatedEvent.class);

  /**
   * Insertion point where distributed nodes were updated.
   */
  private final NodeId insertionPointId;

  /**
   * Distributed nodes for given insertion point.
   */
  private final List<BackendNode> distributedNodes;
}
