package io.github.deripas.chrome.devtools.api.domstorage;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
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
  CompletableFuture<Void> clear(ClearRequest request);

  /**
   * Disables storage tracking, prevents storage events from being sent to the client.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables storage tracking, storage events will now be delivered to the client.
   */
  CompletableFuture<Void> enable();

  CompletableFuture<GetDOMStorageItemsResponse> getDOMStorageItems(
      GetDOMStorageItemsRequest request);

  CompletableFuture<Void> removeDOMStorageItem(RemoveDOMStorageItemRequest request);

  CompletableFuture<Void> setDOMStorageItem(SetDOMStorageItemRequest request);

  Disposable onDomStorageItemAdded(Consumer<DomStorageItemAddedEvent> listener);

  Disposable onDomStorageItemRemoved(Consumer<DomStorageItemRemovedEvent> listener);

  Disposable onDomStorageItemUpdated(Consumer<DomStorageItemUpdatedEvent> listener);

  Disposable onDomStorageItemsCleared(Consumer<DomStorageItemsClearedEvent> listener);

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

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("domStorageItemAdded")
  class DomStorageItemAddedEvent {
    private final StorageId storageId;

    private final String key;

    private final String newValue;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("domStorageItemRemoved")
  class DomStorageItemRemovedEvent {
    private final StorageId storageId;

    private final String key;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("domStorageItemUpdated")
  class DomStorageItemUpdatedEvent {
    private final StorageId storageId;

    private final String key;

    private final String oldValue;

    private final String newValue;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("domStorageItemsCleared")
  class DomStorageItemsClearedEvent {
    private final StorageId storageId;
  }
}
