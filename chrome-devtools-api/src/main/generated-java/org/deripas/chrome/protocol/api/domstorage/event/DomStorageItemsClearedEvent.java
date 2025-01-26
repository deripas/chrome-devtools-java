package org.deripas.chrome.protocol.api.domstorage.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.domstorage.StorageId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class DomStorageItemsClearedEvent {
  public static final EventId<DomStorageItemsClearedEvent> ID = new EventId<>("DOMStorage.domStorageItemsCleared", DomStorageItemsClearedEvent.class);

  private final StorageId storageId;
}
