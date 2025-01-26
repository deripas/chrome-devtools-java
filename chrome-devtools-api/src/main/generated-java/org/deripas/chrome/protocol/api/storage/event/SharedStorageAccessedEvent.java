package org.deripas.chrome.protocol.api.storage.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;
import org.deripas.chrome.protocol.api.page.FrameId;
import org.deripas.chrome.protocol.api.storage.SharedStorageAccessParams;
import org.deripas.chrome.protocol.api.storage.SharedStorageAccessType;

/**
 * Shared storage was accessed by the associated page.
 * The following parameters are included in all events.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedStorageAccessedEvent {
  public static final EventId<SharedStorageAccessedEvent> ID = new EventId<>("Storage.sharedStorageAccessed", SharedStorageAccessedEvent.class);

  /**
   * Time of the access.
   */
  private final TimeSinceEpoch accessTime;

  /**
   * Enum value indicating the Shared Storage API method invoked.
   */
  private final SharedStorageAccessType type;

  /**
   * DevTools Frame Token for the primary frame tree's root.
   */
  private final FrameId mainFrameId;

  /**
   * Serialized origin for the context that invoked the Shared Storage API.
   */
  private final String ownerOrigin;

  /**
   * The sub-parameters wrapped by `params` are all optional and their
   * presence/absence depends on `type`.
   */
  private final SharedStorageAccessParams params;
}
