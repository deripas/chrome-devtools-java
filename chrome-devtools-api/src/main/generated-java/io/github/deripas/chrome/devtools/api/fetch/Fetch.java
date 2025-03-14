package io.github.deripas.chrome.devtools.api.fetch;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.io.StreamHandle;
import io.github.deripas.chrome.devtools.api.network.ErrorReason;
import io.github.deripas.chrome.devtools.api.network.Request;
import io.github.deripas.chrome.devtools.api.network.ResourceType;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * A domain for letting clients substitute browser's network layer with client code.
 */
@RequiredArgsConstructor
@Generated
public class Fetch {
  private final Session session;

  /**
   * Disables the fetch domain.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Fetch.disable", null, Void.class);
  }

  /**
   * Enables issuing of requestPaused events. A request will be paused until client
   * calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("Fetch.enable", request, Void.class);
  }

  /**
   * Causes the request to fail with specified reason.
   */
  public CompletableFuture<Void> failRequest(FailRequestRequest request) {
    return session.send("Fetch.failRequest", request, Void.class);
  }

  /**
   * Provides response to the request.
   */
  public CompletableFuture<Void> fulfillRequest(FulfillRequestRequest request) {
    return session.send("Fetch.fulfillRequest", request, Void.class);
  }

  /**
   * Continues the request, optionally modifying some of its parameters.
   */
  public CompletableFuture<Void> continueRequest(ContinueRequestRequest request) {
    return session.send("Fetch.continueRequest", request, Void.class);
  }

  /**
   * Continues a request supplying authChallengeResponse following authRequired event.
   */
  public CompletableFuture<Void> continueWithAuth(ContinueWithAuthRequest request) {
    return session.send("Fetch.continueWithAuth", request, Void.class);
  }

  /**
   * Continues loading of the paused response, optionally modifying the
   * response headers. If either responseCode or headers are modified, all of them
   * must be present.
   */
  public CompletableFuture<Void> continueResponse(ContinueResponseRequest request) {
    return session.send("Fetch.continueResponse", request, Void.class);
  }

  /**
   * Causes the body of the response to be received from the server and
   * returned as a single string. May only be issued for a request that
   * is paused in the Response stage and is mutually exclusive with
   * takeResponseBodyForInterceptionAsStream. Calling other methods that
   * affect the request or disabling fetch domain before body is received
   * results in an undefined behavior.
   * Note that the response body is not available for redirects. Requests
   * paused in the _redirect received_ state may be differentiated by
   * `responseCode` and presence of `location` response header, see
   * comments to `requestPaused` for details.
   */
  public CompletableFuture<GetResponseBodyResponse> getResponseBody(
      GetResponseBodyRequest request) {
    return session.send("Fetch.getResponseBody", request, GetResponseBodyResponse.class);
  }

  /**
   * Returns a handle to the stream representing the response body.
   * The request must be paused in the HeadersReceived stage.
   * Note that after this command the request can't be continued
   * as is -- client either needs to cancel it or to provide the
   * response body.
   * The stream only supports sequential read, IO.read will fail if the position
   * is specified.
   * This method is mutually exclusive with getResponseBody.
   * Calling other methods that affect the request or disabling fetch
   * domain before body is received results in an undefined behavior.
   */
  public CompletableFuture<TakeResponseBodyAsStreamResponse> takeResponseBodyAsStream(
      TakeResponseBodyAsStreamRequest request) {
    return session.send("Fetch.takeResponseBodyAsStream", request, TakeResponseBodyAsStreamResponse.class);
  }

  public Disposable onRequestPaused(Consumer<RequestPausedEvent> listener) {
    return session.subscribe("Fetch.requestPaused", listener, RequestPausedEvent.class);
  }

  public Disposable onAuthRequired(Consumer<AuthRequiredEvent> listener) {
    return session.subscribe("Fetch.authRequired", listener, AuthRequiredEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
    /**
     * If specified, only requests matching any of these patterns will produce
     * fetchRequested event and will be paused until clients response. If not set,
     * all requests will be affected.
     */
    @Nullable
    private final List<RequestPattern> patterns;

    /**
     * If true, authRequired events will be issued and requests will be paused
     * expecting a call to continueWithAuth.
     */
    @Nullable
    private final Boolean handleAuthRequests;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class FailRequestRequest {
    /**
     * An id the client received in requestPaused event.
     */
    private final RequestId requestId;

    /**
     * Causes the request to fail with the given reason.
     */
    private final ErrorReason errorReason;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class FulfillRequestRequest {
    /**
     * An id the client received in requestPaused event.
     */
    private final RequestId requestId;

    /**
     * An HTTP response code.
     */
    private final Integer responseCode;

    /**
     * Response headers.
     */
    @Nullable
    private final List<HeaderEntry> responseHeaders;

    /**
     * Alternative way of specifying response headers as a \0-separated
     * series of name: value pairs. Prefer the above method unless you
     * need to represent some non-UTF8 values that can't be transmitted
     * over the protocol as text. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String binaryResponseHeaders;

    /**
     * A response body. If absent, original response body will be used if
     * the request is intercepted at the response stage and empty body
     * will be used if the request is intercepted at the request stage. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String body;

    /**
     * A textual representation of responseCode.
     * If absent, a standard phrase matching responseCode is used.
     */
    @Nullable
    private final String responsePhrase;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContinueRequestRequest {
    /**
     * An id the client received in requestPaused event.
     */
    private final RequestId requestId;

    /**
     * If set, the request url will be modified in a way that's not observable by page.
     */
    @Nullable
    private final String url;

    /**
     * If set, the request method is overridden.
     */
    @Nullable
    private final String method;

    /**
     * If set, overrides the post data in the request. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String postData;

    /**
     * If set, overrides the request headers. Note that the overrides do not
     * extend to subsequent redirect hops, if a redirect happens. Another override
     * may be applied to a different request produced by a redirect.
     */
    @Nullable
    private final List<HeaderEntry> headers;

    /**
     * If set, overrides response interception behavior for this request.
     */
    @Nullable
    @Experimental
    private final Boolean interceptResponse;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContinueWithAuthRequest {
    /**
     * An id the client received in authRequired event.
     */
    private final RequestId requestId;

    /**
     * Response to  with an authChallenge.
     */
    private final AuthChallengeResponse authChallengeResponse;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContinueResponseRequest {
    /**
     * An id the client received in requestPaused event.
     */
    private final RequestId requestId;

    /**
     * An HTTP response code. If absent, original response code will be used.
     */
    @Nullable
    private final Integer responseCode;

    /**
     * A textual representation of responseCode.
     * If absent, a standard phrase matching responseCode is used.
     */
    @Nullable
    private final String responsePhrase;

    /**
     * Response headers. If absent, original response headers will be used.
     */
    @Nullable
    private final List<HeaderEntry> responseHeaders;

    /**
     * Alternative way of specifying response headers as a \0-separated
     * series of name: value pairs. Prefer the above method unless you
     * need to represent some non-UTF8 values that can't be transmitted
     * over the protocol as text. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String binaryResponseHeaders;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResponseBodyRequest {
    /**
     * Identifier for the intercepted request to get body for.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResponseBodyResponse {
    /**
     * Response body.
     */
    private final String body;

    /**
     * True, if content was sent as base64.
     */
    private final Boolean base64Encoded;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TakeResponseBodyAsStreamRequest {
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TakeResponseBodyAsStreamResponse {
    private final StreamHandle stream;
  }

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
  public static class RequestPausedEvent {
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
    private final io.github.deripas.chrome.devtools.api.network.RequestId networkId;

    /**
     * If the request is due to a redirect response from the server, the id of the request that
     * has caused the redirect.
     */
    @Nullable
    @Experimental
    private final RequestId redirectedRequestId;
  }

  /**
   * Issued when the domain is enabled with handleAuthRequests set to true.
   * The request is paused until client responds with continueWithAuth.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AuthRequiredEvent {
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
     * Details of the Authorization Challenge encountered.
     * If this is set, client should respond with continueRequest that
     * contains AuthChallengeResponse.
     */
    private final AuthChallenge authChallenge;
  }
}
