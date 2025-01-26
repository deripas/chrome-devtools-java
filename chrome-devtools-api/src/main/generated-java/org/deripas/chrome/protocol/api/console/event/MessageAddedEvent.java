package org.deripas.chrome.protocol.api.console.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.console.ConsoleMessage;

/**
 * Issued when new console message is added.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class MessageAddedEvent {
  public static final EventId<MessageAddedEvent> ID = new EventId<>("Console.messageAdded", MessageAddedEvent.class);

  /**
   * Console message that has been added.
   */
  private final ConsoleMessage message;
}
