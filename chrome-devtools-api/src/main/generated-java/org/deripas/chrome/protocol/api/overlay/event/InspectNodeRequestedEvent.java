package org.deripas.chrome.protocol.api.overlay.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

/**
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
 * user manually inspects an element.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InspectNodeRequestedEvent {
  public static final EventId<InspectNodeRequestedEvent> ID = new EventId<>("Overlay.inspectNodeRequested", InspectNodeRequestedEvent.class);

  /**
   * Id of the node to inspect.
   */
  private final BackendNodeId backendNodeId;
}
