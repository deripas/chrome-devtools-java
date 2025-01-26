package org.deripas.chrome.protocol.api.dom.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Called when shadow root is popped from the element.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ShadowRootPoppedEvent {
  public static final EventId<ShadowRootPoppedEvent> ID = new EventId<>("DOM.shadowRootPopped", ShadowRootPoppedEvent.class);

  /**
   * Host element id.
   */
  private final NodeId hostId;

  /**
   * Shadow root id.
   */
  private final NodeId rootId;
}
