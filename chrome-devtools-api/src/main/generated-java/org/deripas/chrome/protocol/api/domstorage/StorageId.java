package org.deripas.chrome.protocol.api.domstorage;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * DOM Storage identifier.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StorageId {
  /**
   * Security origin for the storage.
   */
  @Nullable
  private final String securityOrigin;

  /**
   * Represents a key by which DOM Storage keys its CachedStorageAreas
   */
  @Nullable
  private final SerializedStorageKey storageKey;

  /**
   * Whether the storage is local storage (not session storage).
   */
  private final Boolean isLocalStorage;
}
