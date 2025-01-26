package org.deripas.chrome.protocol.api.dom.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when `Document` has been totally updated. Node ids are no longer valid.
 */
@Generated
public class DocumentUpdatedEvent {
  public static final EventId<DocumentUpdatedEvent> ID = new EventId<>("DOM.documentUpdated", DocumentUpdatedEvent.class);
}
