package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourcePriority;

/**
 * Fired when resource loading priority is changed
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ResourceChangedPriorityEvent {
  public static final EventId<ResourceChangedPriorityEvent> ID = new EventId<>("Network.resourceChangedPriority", ResourceChangedPriorityEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * New priority
   */
  private final ResourcePriority newPriority;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;
}
