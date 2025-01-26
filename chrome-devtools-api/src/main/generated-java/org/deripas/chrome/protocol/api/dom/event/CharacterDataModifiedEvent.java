package org.deripas.chrome.protocol.api.dom.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.dom.NodeId;

/**
 * Mirrors `DOMCharacterDataModified` event.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CharacterDataModifiedEvent {
  public static final EventId<CharacterDataModifiedEvent> ID = new EventId<>("DOM.characterDataModified", CharacterDataModifiedEvent.class);

  /**
   * Id of the node that has changed.
   */
  private final NodeId nodeId;

  /**
   * New text value.
   */
  private final String characterData;
}
