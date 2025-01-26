package org.deripas.chrome.protocol.api.domstorage.event;

import java.lang.String;
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
public class DomStorageItemUpdatedEvent {
  public static final EventId<DomStorageItemUpdatedEvent> ID = new EventId<>("DOMStorage.domStorageItemUpdated", DomStorageItemUpdatedEvent.class);

  private final StorageId storageId;

  private final String key;

  private final String oldValue;

  private final String newValue;
}
