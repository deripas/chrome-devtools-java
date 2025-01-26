package org.deripas.chrome.protocol.api.network.event;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.AuthChallenge;
import org.deripas.chrome.protocol.api.network.ErrorReason;
import org.deripas.chrome.protocol.api.network.Headers;
import org.deripas.chrome.protocol.api.network.InterceptionId;
import org.deripas.chrome.protocol.api.network.Request;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
 * mocked.
 * Deprecated, use Fetch.requestPaused instead.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RequestInterceptedEvent {
  public static final EventId<RequestInterceptedEvent> ID = new EventId<>("Network.requestIntercepted", RequestInterceptedEvent.class);

  /**
   * Each request the page makes will have a unique id, however if any redirects are encountered
   * while processing that fetch, they will be reported with the same id as the original fetch.
   * Likewise if HTTP authentication is needed then the same fetch id will be used.
   */
  private final InterceptionId interceptionId;

  private final Request request;

  /**
   * The id of the frame that initiated the request.
   */
  private final FrameId frameId;

  /**
   * How the requested resource will be used.
   */
  private final ResourceType resourceType;

  /**
   * Whether this is a navigation request, which can abort the navigation completely.
   */
  private final Boolean isNavigationRequest;

  /**
   * Set if the request is a navigation that will result in a download.
   * Only present after response is received from the server (i.e. HeadersReceived stage).
   */
  @Nullable
  private final Boolean isDownload;

  /**
   * Redirect location, only sent if a redirect was intercepted.
   */
  @Nullable
  private final String redirectUrl;

  /**
   * Details of the Authorization Challenge encountered. If this is set then
   * continueInterceptedRequest must contain an authChallengeResponse.
   */
  @Nullable
  private final AuthChallenge authChallenge;

  /**
   * Response error if intercepted at response stage or if redirect occurred while intercepting
   * request.
   */
  @Nullable
  private final ErrorReason responseErrorReason;

  /**
   * Response code if intercepted at response stage or if redirect occurred while intercepting
   * request or auth retry occurred.
   */
  @Nullable
  private final Integer responseStatusCode;

  /**
   * Response headers if intercepted at the response stage or if redirect occurred while
   * intercepting request or auth retry occurred.
   */
  @Nullable
  private final Headers responseHeaders;

  /**
   * If the intercepted request had a corresponding requestWillBeSent event fired for it, then
   * this requestId will be the same as the requestId present in the requestWillBeSent event.
   */
  @Nullable
  private final RequestId requestId;
}
