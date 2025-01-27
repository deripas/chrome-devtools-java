package org.deripas.chrome.protocol.api.indexeddb;

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
import org.deripas.chrome.protocol.api.storage.StorageBucket;

@Experimental
@Generated
public interface IndexedDB {
  /**
   * Clears all entries from an object store.
   */
  CompletableFuture<Void> clearObjectStore(ClearObjectStoreRequest request);

  /**
   * Deletes a database.
   */
  CompletableFuture<Void> deleteDatabase(DeleteDatabaseRequest request);

  /**
   * Delete a range of entries from an object store
   */
  CompletableFuture<Void> deleteObjectStoreEntries(DeleteObjectStoreEntriesRequest request);

  /**
   * Disables events from backend.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables events from backend.
   */
  CompletableFuture<Void> enable();

  /**
   * Requests data from object store or index.
   */
  CompletableFuture<RequestDataResponse> requestData(RequestDataRequest request);

  /**
   * Gets metadata of an object store.
   */
  CompletableFuture<GetMetadataResponse> getMetadata(GetMetadataRequest request);

  /**
   * Requests database with given name in given frame.
   */
  CompletableFuture<RequestDatabaseResponse> requestDatabase(RequestDatabaseRequest request);

  /**
   * Requests database names for given security origin.
   */
  CompletableFuture<RequestDatabaseNamesResponse> requestDatabaseNames(
      RequestDatabaseNamesRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearObjectStoreRequest {
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
  class DeleteDatabaseRequest {
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
  class DeleteObjectStoreEntriesRequest {
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
  class RequestDataRequest {
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
  class RequestDataResponse {
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
  class GetMetadataRequest {
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
  class GetMetadataResponse {
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
  class RequestDatabaseRequest {
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
  class RequestDatabaseResponse {
    /**
     * Database with an array of object stores.
     */
    private final DatabaseWithObjectStores databaseWithObjectStores;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestDatabaseNamesRequest {
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
  class RequestDatabaseNamesResponse {
    /**
     * Database names for origin.
     */
    private final List<String> databaseNames;
  }
}
