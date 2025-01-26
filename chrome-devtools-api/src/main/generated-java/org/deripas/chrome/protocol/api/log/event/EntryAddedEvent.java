package org.deripas.chrome.protocol.api.log.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.log.LogEntry;

/**
 * Issued when new message was logged.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class EntryAddedEvent {
  public static final EventId<EntryAddedEvent> ID = new EventId<>("Log.entryAdded", EntryAddedEvent.class);

  /**
   * The entry.
   */
  private final LogEntry entry;
}
