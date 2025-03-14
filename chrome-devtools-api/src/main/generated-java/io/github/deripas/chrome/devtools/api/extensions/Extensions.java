package io.github.deripas.chrome.devtools.api.extensions;

import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * Defines commands and events for browser extensions.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Extensions {
  private final Session session;

  /**
   * Installs an unpacked extension from the filesystem similar to
   * --load-extension CLI flags. Returns extension ID once the extension
   * has been installed. Available if the client is connected using the
   * --remote-debugging-pipe flag and the --enable-unsafe-extension-debugging
   * flag is set.
   */
  public CompletableFuture<LoadUnpackedResponse> loadUnpacked(LoadUnpackedRequest request) {
    return session.send("Extensions.loadUnpacked", request, LoadUnpackedResponse.class);
  }

  /**
   * Uninstalls an unpacked extension (others not supported) from the profile.
   * Available if the client is connected using the --remote-debugging-pipe flag
   * and the --enable-unsafe-extension-debugging.
   */
  public CompletableFuture<Void> uninstall(UninstallRequest request) {
    return session.send("Extensions.uninstall", request, Void.class);
  }

  /**
   * Gets data from extension storage in the given `storageArea`. If `keys` is
   * specified, these are used to filter the result.
   */
  public CompletableFuture<GetStorageItemsResponse> getStorageItems(
      GetStorageItemsRequest request) {
    return session.send("Extensions.getStorageItems", request, GetStorageItemsResponse.class);
  }

  /**
   * Removes `keys` from extension storage in the given `storageArea`.
   */
  public CompletableFuture<Void> removeStorageItems(RemoveStorageItemsRequest request) {
    return session.send("Extensions.removeStorageItems", request, Void.class);
  }

  /**
   * Clears extension storage in the given `storageArea`.
   */
  public CompletableFuture<Void> clearStorageItems(ClearStorageItemsRequest request) {
    return session.send("Extensions.clearStorageItems", request, Void.class);
  }

  /**
   * Sets `values` in extension storage in the given `storageArea`. The provided `values`
   * will be merged with existing values in the storage area.
   */
  public CompletableFuture<Void> setStorageItems(SetStorageItemsRequest request) {
    return session.send("Extensions.setStorageItems", request, Void.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadUnpackedRequest {
    /**
     * Absolute file path.
     */
    private final String path;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadUnpackedResponse {
    /**
     * Extension id.
     */
    private final String id;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UninstallRequest {
    /**
     * Extension id.
     */
    private final String id;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetStorageItemsRequest {
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
  public static class GetStorageItemsResponse {
    private final Map data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveStorageItemsRequest {
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
  public static class ClearStorageItemsRequest {
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
  public static class SetStorageItemsRequest {
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
