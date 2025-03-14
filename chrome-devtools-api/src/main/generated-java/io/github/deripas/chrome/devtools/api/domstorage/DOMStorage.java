package io.github.deripas.chrome.devtools.api.domstorage;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * Query and modify DOM storage.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class DOMStorage {
  private final Session session;

  public CompletableFuture<Void> clear(ClearRequest request) {
    return session.send("DOMStorage.clear", request, Void.class);
  }

  /**
   * Disables storage tracking, prevents storage events from being sent to the client.
   */
  public CompletableFuture<Void> disable() {
    return session.send("DOMStorage.disable", null, Void.class);
  }

  /**
   * Enables storage tracking, storage events will now be delivered to the client.
   */
  public CompletableFuture<Void> enable() {
    return session.send("DOMStorage.enable", null, Void.class);
  }

  public CompletableFuture<GetDOMStorageItemsResponse> getDOMStorageItems(
      GetDOMStorageItemsRequest request) {
    return session.send("DOMStorage.getDOMStorageItems", request, GetDOMStorageItemsResponse.class);
  }

  public CompletableFuture<Void> removeDOMStorageItem(RemoveDOMStorageItemRequest request) {
    return session.send("DOMStorage.removeDOMStorageItem", request, Void.class);
  }

  public CompletableFuture<Void> setDOMStorageItem(SetDOMStorageItemRequest request) {
    return session.send("DOMStorage.setDOMStorageItem", request, Void.class);
  }

  public Disposable onDomStorageItemAdded(Consumer<DomStorageItemAddedEvent> listener) {
    return session.subscribe("DOMStorage.domStorageItemAdded", listener, DomStorageItemAddedEvent.class);
  }

  public Disposable onDomStorageItemRemoved(Consumer<DomStorageItemRemovedEvent> listener) {
    return session.subscribe("DOMStorage.domStorageItemRemoved", listener, DomStorageItemRemovedEvent.class);
  }

  public Disposable onDomStorageItemUpdated(Consumer<DomStorageItemUpdatedEvent> listener) {
    return session.subscribe("DOMStorage.domStorageItemUpdated", listener, DomStorageItemUpdatedEvent.class);
  }

  public Disposable onDomStorageItemsCleared(Consumer<DomStorageItemsClearedEvent> listener) {
    return session.subscribe("DOMStorage.domStorageItemsCleared", listener, DomStorageItemsClearedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearRequest {
    private final StorageId storageId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDOMStorageItemsRequest {
    private final StorageId storageId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDOMStorageItemsResponse {
    private final List<Item> entries;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveDOMStorageItemRequest {
    private final StorageId storageId;

    private final String key;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDOMStorageItemRequest {
    private final StorageId storageId;

    private final String key;

    private final String value;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DomStorageItemAddedEvent {
    private final StorageId storageId;

    private final String key;

    private final String newValue;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DomStorageItemRemovedEvent {
    private final StorageId storageId;

    private final String key;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DomStorageItemUpdatedEvent {
    private final StorageId storageId;

    private final String key;

    private final String oldValue;

    private final String newValue;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DomStorageItemsClearedEvent {
    private final StorageId storageId;
  }
}
