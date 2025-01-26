package org.deripas.chrome.protocol.api.storage.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class StorageBucketDeletedEvent {
  public static final EventId<StorageBucketDeletedEvent> ID = new EventId<>("Storage.storageBucketDeleted", StorageBucketDeletedEvent.class);

  private final String bucketId;
}
