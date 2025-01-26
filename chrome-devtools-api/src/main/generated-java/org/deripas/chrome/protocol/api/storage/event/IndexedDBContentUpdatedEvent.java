package org.deripas.chrome.protocol.api.storage.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * The origin's IndexedDB object store has been modified.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class IndexedDBContentUpdatedEvent {
  public static final EventId<IndexedDBContentUpdatedEvent> ID = new EventId<>("Storage.indexedDBContentUpdated", IndexedDBContentUpdatedEvent.class);

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

  /**
   * Database to update.
   */
  private final String databaseName;

  /**
   * ObjectStore to update.
   */
  private final String objectStoreName;
}
