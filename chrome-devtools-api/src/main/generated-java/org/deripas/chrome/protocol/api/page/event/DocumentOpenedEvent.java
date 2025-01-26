package org.deripas.chrome.protocol.api.page.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.Frame;

/**
 * Fired when opening document to write to.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DocumentOpenedEvent {
  public static final EventId<DocumentOpenedEvent> ID = new EventId<>("Page.documentOpened", DocumentOpenedEvent.class);

  /**
   * Frame object.
   */
  private final Frame frame;
}
