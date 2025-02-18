package io.github.deripas.chrome.devtools.api.cachestorage;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.storage.StorageBucket;

/**
 * Cache identifier.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Cache {
  /**
   * An opaque unique id of the cache.
   */
  private final CacheId cacheId;

  /**
   * Security origin of the cache.
   */
  private final String securityOrigin;

  /**
   * Storage key of the cache.
   */
  private final String storageKey;

  /**
   * Storage bucket of the cache.
   */
  @Nullable
  private final StorageBucket storageBucket;

  /**
   * The name of the cache.
   */
  private final String cacheName;
}
