package org.deripas.chrome.protocol.api.storage.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * The origin's IndexedDB database list has been modified.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class IndexedDBListUpdatedEvent {
  public static final EventId<IndexedDBListUpdatedEvent> ID = new EventId<>("Storage.indexedDBListUpdated", IndexedDBListUpdatedEvent.class);

  /**
   * Origin to update.
   */
  private final String origin;

  /**
   * Storage key to update.
   */
  private final String storageKey;

  /**
   * Storage bucket to update.
   */
  private final String bucketId;
}
