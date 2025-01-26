package org.deripas.chrome.protocol.api.network.event;

import java.lang.Boolean;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.network.Response;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when HTTP response is available.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ResponseReceivedEvent {
  public static final EventId<ResponseReceivedEvent> ID = new EventId<>("Network.responseReceived", ResponseReceivedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Loader identifier. Empty string if the request is fetched from worker.
   */
  private final LoaderId loaderId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Resource type.
   */
  private final ResourceType type;

  /**
   * Response data.
   */
  private final Response response;

  /**
   * Indicates whether requestWillBeSentExtraInfo and responseReceivedExtraInfo events will be
   * or were emitted for this request.
   */
  @Experimental
  private final Boolean hasExtraInfo;

  /**
   * Frame identifier.
   */
  @Nullable
  private final FrameId frameId;
}
