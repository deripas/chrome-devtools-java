package org.deripas.chrome.protocol.api.network.event;

import java.lang.Long;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when HTTP request has finished loading.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LoadingFinishedEvent {
  public static final EventId<LoadingFinishedEvent> ID = new EventId<>("Network.loadingFinished", LoadingFinishedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Total number of bytes received for this request.
   */
  private final Long encodedDataLength;
}
