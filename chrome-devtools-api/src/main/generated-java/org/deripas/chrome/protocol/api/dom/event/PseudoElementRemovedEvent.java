package org.deripas.chrome.protocol.api.dom.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Called when a pseudo element is removed from an element.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PseudoElementRemovedEvent {
  public static final EventId<PseudoElementRemovedEvent> ID = new EventId<>("DOM.pseudoElementRemoved", PseudoElementRemovedEvent.class);

  /**
   * Pseudo element's parent element id.
   */
  private final NodeId parentId;

  /**
   * The removed pseudo element id.
   */
  private final NodeId pseudoElementId;
}
