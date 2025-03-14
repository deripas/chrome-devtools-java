package io.github.deripas.chrome.devtools.api.cachestorage;

import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.storage.StorageBucket;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class CacheStorage {
  private final Session session;

  /**
   * Deletes a cache.
   */
  public CompletableFuture<Void> deleteCache(DeleteCacheRequest request) {
    return session.send("CacheStorage.deleteCache", request, Void.class);
  }

  /**
   * Deletes a cache entry.
   */
  public CompletableFuture<Void> deleteEntry(DeleteEntryRequest request) {
    return session.send("CacheStorage.deleteEntry", request, Void.class);
  }

  /**
   * Requests cache names.
   */
  public CompletableFuture<RequestCacheNamesResponse> requestCacheNames(
      RequestCacheNamesRequest request) {
    return session.send("CacheStorage.requestCacheNames", request, RequestCacheNamesResponse.class);
  }

  /**
   * Fetches cache entry.
   */
  public CompletableFuture<RequestCachedResponseResponse> requestCachedResponse(
      RequestCachedResponseRequest request) {
    return session.send("CacheStorage.requestCachedResponse", request, RequestCachedResponseResponse.class);
  }

  /**
   * Requests data from cache.
   */
  public CompletableFuture<RequestEntriesResponse> requestEntries(RequestEntriesRequest request) {
    return session.send("CacheStorage.requestEntries", request, RequestEntriesResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeleteCacheRequest {
    /**
     * Id of cache for deletion.
     */
    private final CacheId cacheId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeleteEntryRequest {
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
  public static class RequestCacheNamesRequest {
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
  public static class RequestCacheNamesResponse {
    /**
     * Caches for the security origin.
     */
    private final List<Cache> caches;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestCachedResponseRequest {
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
  public static class RequestCachedResponseResponse {
    /**
     * Response read from the cache.
     */
    private final CachedResponse response;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestEntriesRequest {
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
  public static class RequestEntriesResponse {
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
