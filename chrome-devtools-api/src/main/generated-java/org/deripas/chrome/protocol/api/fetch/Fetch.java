package org.deripas.chrome.protocol.api.fetch;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.io.StreamHandle;
import org.deripas.chrome.protocol.api.network.ErrorReason;

/**
 * A domain for letting clients substitute browser's network layer with client code.
 */
@Generated
public interface Fetch {
  /**
   * Disables the fetch domain.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables issuing of requestPaused events. A request will be paused until client
   * calls one of failRequest, fulfillRequest or continueRequest/continueWithAuth.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Causes the request to fail with specified reason.
   */
  CompletableFuture<Void> failRequest(FailRequestRequest request);

  /**
   * Provides response to the request.
   */
  CompletableFuture<Void> fulfillRequest(FulfillRequestRequest request);

  /**
   * Continues the request, optionally modifying some of its parameters.
   */
  CompletableFuture<Void> continueRequest(ContinueRequestRequest request);

  /**
   * Continues a request supplying authChallengeResponse following authRequired event.
   */
  CompletableFuture<Void> continueWithAuth(ContinueWithAuthRequest request);

  /**
   * Continues loading of the paused response, optionally modifying the
   * response headers. If either responseCode or headers are modified, all of them
   * must be present.
   */
  CompletableFuture<Void> continueResponse(ContinueResponseRequest request);

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
  CompletableFuture<GetResponseBodyResponse> getResponseBody(GetResponseBodyRequest request);

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
  CompletableFuture<TakeResponseBodyAsStreamResponse> takeResponseBodyAsStream(
      TakeResponseBodyAsStreamRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
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
  class FailRequestRequest {
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
  class FulfillRequestRequest {
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
  class ContinueRequestRequest {
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
  class ContinueWithAuthRequest {
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
  class ContinueResponseRequest {
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
  class GetResponseBodyRequest {
    /**
     * Identifier for the intercepted request to get body for.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetResponseBodyResponse {
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
  class TakeResponseBodyAsStreamRequest {
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TakeResponseBodyAsStreamResponse {
    private final StreamHandle stream;
  }
}
