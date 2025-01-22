package org.deripas.chrome.protocol.api.domstorage;

import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Query and modify DOM storage.
 */
@Experimental
@Generated
public interface DOMStorage {
  void clear(ClearRequest request);

  /**
   * Disables storage tracking, prevents storage events from being sent to the client.
   */
  void disable();

  /**
   * Enables storage tracking, storage events will now be delivered to the client.
   */
  void enable();

  CompletableFuture<GetDOMStorageItemsResponse> getDOMStorageItems(
      GetDOMStorageItemsRequest request);

  void removeDOMStorageItem(RemoveDOMStorageItemRequest request);

  void setDOMStorageItem(SetDOMStorageItemRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearRequest {
    private final StorageId storageId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDOMStorageItemsRequest {
    private final StorageId storageId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDOMStorageItemsResponse {
    private final List<Item> entries;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveDOMStorageItemRequest {
    private final StorageId storageId;

    private final String key;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDOMStorageItemRequest {
    private final StorageId storageId;

    private final String key;

    private final String value;
  }
}
