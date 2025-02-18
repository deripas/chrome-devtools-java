package io.github.deripas.chrome.devtools.api.cachestorage;

import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.storage.StorageBucket;

@Experimental
@Generated
public interface CacheStorage {
  /**
   * Deletes a cache.
   */
  CompletableFuture<Void> deleteCache(DeleteCacheRequest request);

  /**
   * Deletes a cache entry.
   */
  CompletableFuture<Void> deleteEntry(DeleteEntryRequest request);

  /**
   * Requests cache names.
   */
  CompletableFuture<RequestCacheNamesResponse> requestCacheNames(RequestCacheNamesRequest request);

  /**
   * Fetches cache entry.
   */
  CompletableFuture<RequestCachedResponseResponse> requestCachedResponse(
      RequestCachedResponseRequest request);

  /**
   * Requests data from cache.
   */
  CompletableFuture<RequestEntriesResponse> requestEntries(RequestEntriesRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class DeleteCacheRequest {
    /**
     * Id of cache for deletion.
     */
    private final CacheId cacheId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DeleteEntryRequest {
    /**
     * Id of cache where the entry will be deleted.
     */
    private final CacheId cacheId;

    /**
     * URL spec of the request.
     */
    private final String request;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestCacheNamesRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, storageBucket must be specified.
     * Security origin.
     */
    @Nullable
    private final String securityOrigin;

    /**
     * Storage key.
     */
    @Nullable
    private final String storageKey;

    /**
     * Storage bucket. If not specified, it uses the default bucket.
     */
    @Nullable
    private final StorageBucket storageBucket;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestCacheNamesResponse {
    /**
     * Caches for the security origin.
     */
    private final List<Cache> caches;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestCachedResponseRequest {
    /**
     * Id of cache that contains the entry.
     */
    private final CacheId cacheId;

    /**
     * URL spec of the request.
     */
    private final String requestURL;

    /**
     * headers of the request.
     */
    private final List<Header> requestHeaders;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestCachedResponseResponse {
    /**
     * Response read from the cache.
     */
    private final CachedResponse response;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestEntriesRequest {
    /**
     * ID of cache to get entries from.
     */
    private final CacheId cacheId;

    /**
     * Number of records to skip.
     */
    @Nullable
    private final Integer skipCount;

    /**
     * Number of records to fetch.
     */
    @Nullable
    private final Integer pageSize;

    /**
     * If present, only return the entries containing this substring in the path
     */
    @Nullable
    private final String pathFilter;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestEntriesResponse {
    /**
     * Array of object store data entries.
     */
    private final List<DataEntry> cacheDataEntries;

    /**
     * Count of returned entries from this storage. If pathFilter is empty, it
     * is the count of all entries from this storage.
     */
    private final Double returnCount;
  }
}
