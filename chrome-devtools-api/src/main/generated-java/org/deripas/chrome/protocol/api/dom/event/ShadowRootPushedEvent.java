package org.deripas.chrome.protocol.api.dom.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.Node;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Called when shadow root is pushed into the element.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ShadowRootPushedEvent {
  public static final EventId<ShadowRootPushedEvent> ID = new EventId<>("DOM.shadowRootPushed", ShadowRootPushedEvent.class);

  /**
   * Host element id.
   */
  private final NodeId hostId;

  /**
   * Shadow root.
   */
  private final Node root;
}
