package org.deripas.chrome.protocol.api.storage.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * A cache has been added/deleted.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CacheStorageListUpdatedEvent {
  public static final EventId<CacheStorageListUpdatedEvent> ID = new EventId<>("Storage.cacheStorageListUpdated", CacheStorageListUpdatedEvent.class);

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
