package org.deripas.chrome.protocol.api.fetch.event;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.fetch.HeaderEntry;
import org.deripas.chrome.protocol.api.fetch.RequestId;
import org.deripas.chrome.protocol.api.network.ErrorReason;
import org.deripas.chrome.protocol.api.network.Request;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Issued when the domain is enabled and the request URL matches the
 * specified filter. The request is paused until the client responds
 * with one of continueRequest, failRequest or fulfillRequest.
 * The stage of the request can be determined by presence of responseErrorReason
 * and responseStatusCode -- the request is at the response stage if either
 * of these fields is present and in the request stage otherwise.
 * Redirect responses and subsequent requests are reported similarly to regular
 * responses and requests. Redirect responses may be distinguished by the value
 * of `responseStatusCode` (which is one of 301, 302, 303, 307, 308) along with
 * presence of the `location` header. Requests resulting from a redirect will
 * have `redirectedRequestId` field set.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RequestPausedEvent {
  public static final EventId<RequestPausedEvent> ID = new EventId<>("Fetch.requestPaused", RequestPausedEvent.class);

  /**
   * Each request the page makes will have a unique id.
   */
  private final RequestId requestId;

  /**
   * The details of the request.
   */
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
   * Response error if intercepted at response stage.
   */
  @Nullable
  private final ErrorReason responseErrorReason;

  /**
   * Response code if intercepted at response stage.
   */
  @Nullable
  private final Integer responseStatusCode;

  /**
   * Response status text if intercepted at response stage.
   */
  @Nullable
  private final String responseStatusText;

  /**
   * Response headers if intercepted at the response stage.
   */
  @Nullable
  private final List<HeaderEntry> responseHeaders;

  /**
   * If the intercepted request had a corresponding Network.requestWillBeSent event fired for it,
   * then this networkId will be the same as the requestId present in the requestWillBeSent event.
   */
  @Nullable
  private final org.deripas.chrome.protocol.api.network.RequestId networkId;

  /**
   * If the request is due to a redirect response from the server, the id of the request that
   * has caused the redirect.
   */
  @Nullable
  @Experimental
  private final RequestId redirectedRequestId;
}
