package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired if request ended up loading from cache.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RequestServedFromCacheEvent {
  public static final EventId<RequestServedFromCacheEvent> ID = new EventId<>("Network.requestServedFromCache", RequestServedFromCacheEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;
}
