package org.deripas.chrome.protocol.api.extensions;

import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Defines commands and events for browser extensions.
 */
@Experimental
@Generated
public interface Extensions {
  /**
   * Installs an unpacked extension from the filesystem similar to
   * --load-extension CLI flags. Returns extension ID once the extension
   * has been installed. Available if the client is connected using the
   * --remote-debugging-pipe flag and the --enable-unsafe-extension-debugging
   * flag is set.
   */
  CompletableFuture<LoadUnpackedResponse> loadUnpacked(LoadUnpackedRequest request);

  /**
   * Gets data from extension storage in the given `storageArea`. If `keys` is
   * specified, these are used to filter the result.
   */
  CompletableFuture<GetStorageItemsResponse> getStorageItems(GetStorageItemsRequest request);

  /**
   * Removes `keys` from extension storage in the given `storageArea`.
   */
  CompletableFuture<Void> removeStorageItems(RemoveStorageItemsRequest request);

  /**
   * Clears extension storage in the given `storageArea`.
   */
  CompletableFuture<Void> clearStorageItems(ClearStorageItemsRequest request);

  /**
   * Sets `values` in extension storage in the given `storageArea`. The provided `values`
   * will be merged with existing values in the storage area.
   */
  CompletableFuture<Void> setStorageItems(SetStorageItemsRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class LoadUnpackedRequest {
    /**
     * Absolute file path.
     */
    private final String path;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class LoadUnpackedResponse {
    /**
     * Extension id.
     */
    private final String id;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetStorageItemsRequest {
    /**
     * ID of extension.
     */
    private final String id;

    /**
     * StorageArea to retrieve data from.
     */
    private final StorageArea storageArea;

    /**
     * Keys to retrieve.
     */
    @Nullable
    private final List<String> keys;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetStorageItemsResponse {
    private final Map data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveStorageItemsRequest {
    /**
     * ID of extension.
     */
    private final String id;

    /**
     * StorageArea to remove data from.
     */
    private final StorageArea storageArea;

    /**
     * Keys to remove.
     */
    private final List<String> keys;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearStorageItemsRequest {
    /**
     * ID of extension.
     */
    private final String id;

    /**
     * StorageArea to remove data from.
     */
    private final StorageArea storageArea;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetStorageItemsRequest {
    /**
     * ID of extension.
     */
    private final String id;

    /**
     * StorageArea to set data in.
     */
    private final StorageArea storageArea;

    /**
     * Values to set.
     */
    private final Map values;
  }
}
