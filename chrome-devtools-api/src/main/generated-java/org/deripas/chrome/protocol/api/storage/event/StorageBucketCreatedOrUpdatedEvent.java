package org.deripas.chrome.protocol.api.storage.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.storage.StorageBucketInfo;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class StorageBucketCreatedOrUpdatedEvent {
  public static final EventId<StorageBucketCreatedOrUpdatedEvent> ID = new EventId<>("Storage.storageBucketCreatedOrUpdated", StorageBucketCreatedOrUpdatedEvent.class);

  private final StorageBucketInfo bucketInfo;
}
