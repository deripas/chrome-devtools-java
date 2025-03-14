package io.github.deripas.chrome.devtools.api.indexeddb;

import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.storage.StorageBucket;
import java.lang.Boolean;
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
public class IndexedDB {
  private final Session session;

  /**
   * Clears all entries from an object store.
   */
  public CompletableFuture<Void> clearObjectStore(ClearObjectStoreRequest request) {
    return session.send("IndexedDB.clearObjectStore", request, Void.class);
  }

  /**
   * Deletes a database.
   */
  public CompletableFuture<Void> deleteDatabase(DeleteDatabaseRequest request) {
    return session.send("IndexedDB.deleteDatabase", request, Void.class);
  }

  /**
   * Delete a range of entries from an object store
   */
  public CompletableFuture<Void> deleteObjectStoreEntries(DeleteObjectStoreEntriesRequest request) {
    return session.send("IndexedDB.deleteObjectStoreEntries", request, Void.class);
  }

  /**
   * Disables events from backend.
   */
  public CompletableFuture<Void> disable() {
    return session.send("IndexedDB.disable", null, Void.class);
  }

  /**
   * Enables events from backend.
   */
  public CompletableFuture<Void> enable() {
    return session.send("IndexedDB.enable", null, Void.class);
  }

  /**
   * Requests data from object store or index.
   */
  public CompletableFuture<RequestDataResponse> requestData(RequestDataRequest request) {
    return session.send("IndexedDB.requestData", request, RequestDataResponse.class);
  }

  /**
   * Gets metadata of an object store.
   */
  public CompletableFuture<GetMetadataResponse> getMetadata(GetMetadataRequest request) {
    return session.send("IndexedDB.getMetadata", request, GetMetadataResponse.class);
  }

  /**
   * Requests database with given name in given frame.
   */
  public CompletableFuture<RequestDatabaseResponse> requestDatabase(
      RequestDatabaseRequest request) {
    return session.send("IndexedDB.requestDatabase", request, RequestDatabaseResponse.class);
  }

  /**
   * Requests database names for given security origin.
   */
  public CompletableFuture<RequestDatabaseNamesResponse> requestDatabaseNames(
      RequestDatabaseNamesRequest request) {
    return session.send("IndexedDB.requestDatabaseNames", request, RequestDatabaseNamesResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearObjectStoreRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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

    /**
     * Database name.
     */
    private final String databaseName;

    /**
     * Object store name.
     */
    private final String objectStoreName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeleteDatabaseRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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

    /**
     * Database name.
     */
    private final String databaseName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeleteObjectStoreEntriesRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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

    private final String databaseName;

    private final String objectStoreName;

    /**
     * Range of entry keys to delete
     */
    private final KeyRange keyRange;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestDataRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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

    /**
     * Database name.
     */
    private final String databaseName;

    /**
     * Object store name.
     */
    private final String objectStoreName;

    /**
     * Index name, empty string for object store data requests.
     */
    private final String indexName;

    /**
     * Number of records to skip.
     */
    private final Integer skipCount;

    /**
     * Number of records to fetch.
     */
    private final Integer pageSize;

    /**
     * Key range.
     */
    @Nullable
    private final KeyRange keyRange;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestDataResponse {
    /**
     * Array of object store data entries.
     */
    private final List<DataEntry> objectStoreDataEntries;

    /**
     * If true, there are more entries to fetch in the given range.
     */
    private final Boolean hasMore;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetMetadataRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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

    /**
     * Database name.
     */
    private final String databaseName;

    /**
     * Object store name.
     */
    private final String objectStoreName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetMetadataResponse {
    /**
     * the entries count
     */
    private final Double entriesCount;

    /**
     * the current value of key generator, to become the next inserted
     * key into the object store. Valid if objectStore.autoIncrement
     * is true.
     */
    private final Double keyGeneratorValue;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestDatabaseRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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

    /**
     * Database name.
     */
    private final String databaseName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestDatabaseResponse {
    /**
     * Database with an array of object stores.
     */
    private final DatabaseWithObjectStores databaseWithObjectStores;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestDatabaseNamesRequest {
    /**
     * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
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
  public static class RequestDatabaseNamesResponse {
    /**
     * Database names for origin.
     */
    private final List<String> databaseNames;
  }
}
