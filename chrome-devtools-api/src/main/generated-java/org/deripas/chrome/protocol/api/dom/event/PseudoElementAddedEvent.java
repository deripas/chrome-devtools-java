package org.deripas.chrome.protocol.api.dom.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.Node;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Called when a pseudo element is added to an element.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PseudoElementAddedEvent {
  public static final EventId<PseudoElementAddedEvent> ID = new EventId<>("DOM.pseudoElementAdded", PseudoElementAddedEvent.class);

  /**
   * Pseudo element's parent element id.
   */
  private final NodeId parentId;

  /**
   * The added pseudo element.
   */
  private final Node pseudoElement;
}
