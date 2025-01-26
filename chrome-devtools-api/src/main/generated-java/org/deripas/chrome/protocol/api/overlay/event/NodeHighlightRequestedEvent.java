package org.deripas.chrome.protocol.api.overlay.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodeHighlightRequestedEvent {
  public static final EventId<NodeHighlightRequestedEvent> ID = new EventId<>("Overlay.nodeHighlightRequested", NodeHighlightRequestedEvent.class);

  private final NodeId nodeId;
}
