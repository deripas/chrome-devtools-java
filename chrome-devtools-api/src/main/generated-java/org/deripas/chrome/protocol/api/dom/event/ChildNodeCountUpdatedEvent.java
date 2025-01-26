package org.deripas.chrome.protocol.api.dom.event;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when `Container`'s child node count has changed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ChildNodeCountUpdatedEvent {
  public static final EventId<ChildNodeCountUpdatedEvent> ID = new EventId<>("DOM.childNodeCountUpdated", ChildNodeCountUpdatedEvent.class);

  /**
   * Id of the node that has changed.
   */
  private final NodeId nodeId;

  /**
   * New node count.
   */
  private final Integer childNodeCount;
}
