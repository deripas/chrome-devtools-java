package org.deripas.chrome.protocol.api.network.event;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.Initiator;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.Request;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.network.Response;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when page is about to send HTTP request.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RequestWillBeSentEvent {
  public static final EventId<RequestWillBeSentEvent> ID = new EventId<>("Network.requestWillBeSent", RequestWillBeSentEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Loader identifier. Empty string if the request is fetched from worker.
   */
  private final LoaderId loaderId;

  /**
   * URL of the document this request is loaded for.
   */
  private final String documentURL;

  /**
   * Request data.
   */
  private final Request request;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Timestamp.
   */
  private final TimeSinceEpoch wallTime;

  /**
   * Request initiator.
   */
  private final Initiator initiator;

  /**
   * In the case that redirectResponse is populated, this flag indicates whether
   * requestWillBeSentExtraInfo and responseReceivedExtraInfo events will be or were emitted
   * for the request which was just redirected.
   */
  @Experimental
  private final Boolean redirectHasExtraInfo;

  /**
   * Redirect response data.
   */
  @Nullable
  private final Response redirectResponse;

  /**
   * Type of this resource.
   */
  @Nullable
  private final ResourceType type;

  /**
   * Frame identifier.
   */
  @Nullable
  private final FrameId frameId;

  /**
   * Whether the request is initiated by a user gesture. Defaults to false.
   */
  @Nullable
  private final Boolean hasUserGesture;
}
