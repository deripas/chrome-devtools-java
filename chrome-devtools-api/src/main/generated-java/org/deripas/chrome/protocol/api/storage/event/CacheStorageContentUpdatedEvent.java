package org.deripas.chrome.protocol.api.storage.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * A cache's contents have been modified.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CacheStorageContentUpdatedEvent {
  public static final EventId<CacheStorageContentUpdatedEvent> ID = new EventId<>("Storage.cacheStorageContentUpdated", CacheStorageContentUpdatedEvent.class);

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
   * Name of cache in origin.
   */
  private final String cacheName;
}
