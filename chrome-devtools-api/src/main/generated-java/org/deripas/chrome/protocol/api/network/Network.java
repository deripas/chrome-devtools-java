package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
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
import org.deripas.chrome.protocol.api.debugger.SearchMatch;
import org.deripas.chrome.protocol.api.emulation.UserAgentMetadata;
import org.deripas.chrome.protocol.api.io.StreamHandle;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Network domain allows tracking network activities of the page. It exposes information about http,
 * file, data and other requests and responses, their headers, bodies, timing, etc.
 */
@Generated
public interface Network {
  /**
   * Sets a list of content encodings that will be accepted. Empty list means no encoding is accepted.
   */
  CompletableFuture<Void> setAcceptedEncodings(SetAcceptedEncodingsRequest request);

  /**
   * Clears accepted encodings set by setAcceptedEncodings
   */
  CompletableFuture<Void> clearAcceptedEncodingsOverride();

  /**
   * Tells whether clearing browser cache is supported.
   */
  @Deprecated
  CompletableFuture<CanClearBrowserCacheResponse> canClearBrowserCache();

  /**
   * Tells whether clearing browser cookies is supported.
   */
  @Deprecated
  CompletableFuture<CanClearBrowserCookiesResponse> canClearBrowserCookies();

  /**
   * Tells whether emulation of network conditions is supported.
   */
  @Deprecated
  CompletableFuture<CanEmulateNetworkConditionsResponse> canEmulateNetworkConditions();

  /**
   * Clears browser cache.
   */
  CompletableFuture<Void> clearBrowserCache();

  /**
   * Clears browser cookies.
   */
  CompletableFuture<Void> clearBrowserCookies();

  /**
   * Response to Network.requestIntercepted which either modifies the request to continue with any
   * modifications, or blocks it, or completes it with the provided response bytes. If a network
   * fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
   * event will be sent with the same InterceptionId.
   * Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
   */
  @Deprecated
  CompletableFuture<Void> continueInterceptedRequest(ContinueInterceptedRequestRequest request);

  /**
   * Deletes browser cookies with matching name and url or domain/path/partitionKey pair.
   */
  CompletableFuture<Void> deleteCookies(DeleteCookiesRequest request);

  /**
   * Disables network tracking, prevents network events from being sent to the client.
   */
  CompletableFuture<Void> disable();

  /**
   * Activates emulation of network conditions.
   */
  CompletableFuture<Void> emulateNetworkConditions(EmulateNetworkConditionsRequest request);

  /**
   * Enables network tracking, network events will now be delivered to the client.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Returns all browser cookies. Depending on the backend support, will return detailed cookie
   * information in the `cookies` field.
   * Deprecated. Use Storage.getCookies instead.
   */
  @Deprecated
  CompletableFuture<GetAllCookiesResponse> getAllCookies();

  /**
   * Returns the DER-encoded certificate.
   */
  CompletableFuture<GetCertificateResponse> getCertificate(GetCertificateRequest request);

  /**
   * Returns all browser cookies for the current URL. Depending on the backend support, will return
   * detailed cookie information in the `cookies` field.
   */
  CompletableFuture<GetCookiesResponse> getCookies(GetCookiesRequest request);

  /**
   * Returns content served for the given request.
   */
  CompletableFuture<GetResponseBodyResponse> getResponseBody(GetResponseBodyRequest request);

  /**
   * Returns post data sent with the request. Returns an error when no data was sent with the request.
   */
  CompletableFuture<GetRequestPostDataResponse> getRequestPostData(
      GetRequestPostDataRequest request);

  /**
   * Returns content served for the given currently intercepted request.
   */
  CompletableFuture<GetResponseBodyForInterceptionResponse> getResponseBodyForInterception(
      GetResponseBodyForInterceptionRequest request);

  /**
   * Returns a handle to the stream representing the response body. Note that after this command,
   * the intercepted request can't be continued as is -- you either need to cancel it or to provide
   * the response body. The stream only supports sequential read, IO.read will fail if the position
   * is specified.
   */
  CompletableFuture<TakeResponseBodyForInterceptionAsStreamResponse> takeResponseBodyForInterceptionAsStream(
      TakeResponseBodyForInterceptionAsStreamRequest request);

  /**
   * This method sends a new XMLHttpRequest which is identical to the original one. The following
   * parameters should be identical: method, url, async, request body, extra headers, withCredentials
   * attribute, user, password.
   */
  CompletableFuture<Void> replayXHR(ReplayXHRRequest request);

  /**
   * Searches for given string in response content.
   */
  CompletableFuture<SearchInResponseBodyResponse> searchInResponseBody(
      SearchInResponseBodyRequest request);

  /**
   * Blocks URLs from loading.
   */
  CompletableFuture<Void> setBlockedURLs(SetBlockedURLsRequest request);

  /**
   * Toggles ignoring of service worker for each request.
   */
  CompletableFuture<Void> setBypassServiceWorker(SetBypassServiceWorkerRequest request);

  /**
   * Toggles ignoring cache for each request. If `true`, cache will not be used.
   */
  CompletableFuture<Void> setCacheDisabled(SetCacheDisabledRequest request);

  /**
   * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
   */
  CompletableFuture<SetCookieResponse> setCookie(SetCookieRequest request);

  /**
   * Sets given cookies.
   */
  CompletableFuture<Void> setCookies(SetCookiesRequest request);

  /**
   * Specifies whether to always send extra HTTP headers with the requests from this page.
   */
  CompletableFuture<Void> setExtraHTTPHeaders(SetExtraHTTPHeadersRequest request);

  /**
   * Specifies whether to attach a page script stack id in requests
   */
  CompletableFuture<Void> setAttachDebugStack(SetAttachDebugStackRequest request);

  /**
   * Sets the requests to intercept that match the provided patterns and optionally resource types.
   * Deprecated, please use Fetch.enable instead.
   */
  @Deprecated
  CompletableFuture<Void> setRequestInterception(SetRequestInterceptionRequest request);

  /**
   * Allows overriding user agent with the given string.
   */
  CompletableFuture<Void> setUserAgentOverride(SetUserAgentOverrideRequest request);

  /**
   * Enables streaming of the response for the given requestId.
   * If enabled, the dataReceived event contains the data that was received during streaming.
   */
  CompletableFuture<StreamResourceContentResponse> streamResourceContent(
      StreamResourceContentRequest request);

  /**
   * Returns information about the COEP/COOP isolation status.
   */
  CompletableFuture<GetSecurityIsolationStatusResponse> getSecurityIsolationStatus(
      GetSecurityIsolationStatusRequest request);

  /**
   * Enables tracking for the Reporting API, events generated by the Reporting API will now be delivered to the client.
   * Enabling triggers 'reportingApiReportAdded' for all existing reports.
   */
  CompletableFuture<Void> enableReportingApi(EnableReportingApiRequest request);

  /**
   * Fetches the resource and returns the content.
   */
  CompletableFuture<LoadNetworkResourceResponse> loadNetworkResource(
      LoadNetworkResourceRequest request);

  /**
   * Sets Controls for third-party cookie access
   * Page reload is required before the new cookie bahavior will be observed
   */
  CompletableFuture<Void> setCookieControls(SetCookieControlsRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAcceptedEncodingsRequest {
    /**
     * List of accepted content encodings.
     */
    private final List<ContentEncoding> encodings;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CanClearBrowserCacheResponse {
    /**
     * True if browser cache can be cleared.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CanClearBrowserCookiesResponse {
    /**
     * True if browser cookies can be cleared.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CanEmulateNetworkConditionsResponse {
    /**
     * True if emulation of network conditions is supported.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ContinueInterceptedRequestRequest {
    private final InterceptionId interceptionId;

    /**
     * If set this causes the request to fail with the given reason. Passing `Aborted` for requests
     * marked with `isNavigationRequest` also cancels the navigation. Must not be set in response
     * to an authChallenge.
     */
    @Nullable
    private final ErrorReason errorReason;

    /**
     * If set the requests completes using with the provided base64 encoded raw response, including
     * HTTP status line and headers etc... Must not be set in response to an authChallenge. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String rawResponse;

    /**
     * If set the request url will be modified in a way that's not observable by page. Must not be
     * set in response to an authChallenge.
     */
    @Nullable
    private final String url;

    /**
     * If set this allows the request method to be overridden. Must not be set in response to an
     * authChallenge.
     */
    @Nullable
    private final String method;

    /**
     * If set this allows postData to be set. Must not be set in response to an authChallenge.
     */
    @Nullable
    private final String postData;

    /**
     * If set this allows the request headers to be changed. Must not be set in response to an
     * authChallenge.
     */
    @Nullable
    private final Headers headers;

    /**
     * Response to a requestIntercepted with an authChallenge. Must not be set otherwise.
     */
    @Nullable
    private final AuthChallengeResponse authChallengeResponse;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DeleteCookiesRequest {
    /**
     * Name of the cookies to remove.
     */
    private final String name;

    /**
     * If specified, deletes all the cookies with the given name where domain and path match
     * provided URL.
     */
    @Nullable
    private final String url;

    /**
     * If specified, deletes only cookies with the exact domain.
     */
    @Nullable
    private final String domain;

    /**
     * If specified, deletes only cookies with the exact path.
     */
    @Nullable
    private final String path;

    /**
     * If specified, deletes only cookies with the the given name and partitionKey where
     * all partition key attributes match the cookie partition key attribute.
     */
    @Nullable
    @Experimental
    private final CookiePartitionKey partitionKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class EmulateNetworkConditionsRequest {
    /**
     * True to emulate internet disconnection.
     */
    private final Boolean offline;

    /**
     * Minimum latency from request sent to response headers received (ms).
     */
    private final Double latency;

    /**
     * Maximal aggregated download throughput (bytes/sec). -1 disables download throttling.
     */
    private final Double downloadThroughput;

    /**
     * Maximal aggregated upload throughput (bytes/sec).  -1 disables upload throttling.
     */
    private final Double uploadThroughput;

    /**
     * Connection type if known.
     */
    @Nullable
    private final ConnectionType connectionType;

    /**
     * WebRTC packet loss (percent, 0-100). 0 disables packet loss emulation, 100 drops all the packets.
     */
    @Nullable
    @Experimental
    private final Double packetLoss;

    /**
     * WebRTC packet queue length (packet). 0 removes any queue length limitations.
     */
    @Nullable
    @Experimental
    private final Integer packetQueueLength;

    /**
     * WebRTC packetReordering feature.
     */
    @Nullable
    @Experimental
    private final Boolean packetReordering;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    /**
     * Buffer size in bytes to use when preserving network payloads (XHRs, etc).
     */
    @Nullable
    @Experimental
    private final Integer maxTotalBufferSize;

    /**
     * Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
     */
    @Nullable
    @Experimental
    private final Integer maxResourceBufferSize;

    /**
     * Longest post body size (in bytes) that would be included in requestWillBeSent notification
     */
    @Nullable
    private final Integer maxPostDataSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAllCookiesResponse {
    /**
     * Array of cookie objects.
     */
    private final List<Cookie> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCertificateRequest {
    /**
     * Origin to get certificate for.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCertificateResponse {
    private final List<String> tableNames;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCookiesRequest {
    /**
     * The list of URLs for which applicable cookies will be fetched.
     * If not specified, it's assumed to be set to the list containing
     * the URLs of the page and all of its subframes.
     */
    @Nullable
    private final List<String> urls;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCookiesResponse {
    /**
     * Array of cookie objects.
     */
    private final List<Cookie> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetResponseBodyRequest {
    /**
     * Identifier of the network request to get content for.
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
  class GetRequestPostDataRequest {
    /**
     * Identifier of the network request to get content for.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRequestPostDataResponse {
    /**
     * Request body string, omitting files from multipart requests
     */
    private final String postData;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetResponseBodyForInterceptionRequest {
    /**
     * Identifier for the intercepted request to get body for.
     */
    private final InterceptionId interceptionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetResponseBodyForInterceptionResponse {
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
  class TakeResponseBodyForInterceptionAsStreamRequest {
    private final InterceptionId interceptionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TakeResponseBodyForInterceptionAsStreamResponse {
    private final StreamHandle stream;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReplayXHRRequest {
    /**
     * Identifier of XHR to replay.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SearchInResponseBodyRequest {
    /**
     * Identifier of the network response to search.
     */
    private final RequestId requestId;

    /**
     * String to search for.
     */
    private final String query;

    /**
     * If true, search is case sensitive.
     */
    @Nullable
    private final Boolean caseSensitive;

    /**
     * If true, treats string parameter as regex.
     */
    @Nullable
    private final Boolean isRegex;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SearchInResponseBodyResponse {
    /**
     * List of search matches.
     */
    private final List<SearchMatch> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetBlockedURLsRequest {
    /**
     * URL patterns to block. Wildcards ('*') are allowed.
     */
    private final List<String> urls;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetBypassServiceWorkerRequest {
    /**
     * Bypass service worker and load from network.
     */
    private final Boolean bypass;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCacheDisabledRequest {
    /**
     * Cache disabled state.
     */
    private final Boolean cacheDisabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCookieRequest {
    /**
     * Cookie name.
     */
    private final String name;

    /**
     * Cookie value.
     */
    private final String value;

    /**
     * The request-URI to associate with the setting of the cookie. This value can affect the
     * default domain, path, source port, and source scheme values of the created cookie.
     */
    @Nullable
    private final String url;

    /**
     * Cookie domain.
     */
    @Nullable
    private final String domain;

    /**
     * Cookie path.
     */
    @Nullable
    private final String path;

    /**
     * True if cookie is secure.
     */
    @Nullable
    private final Boolean secure;

    /**
     * True if cookie is http-only.
     */
    @Nullable
    private final Boolean httpOnly;

    /**
     * Cookie SameSite type.
     */
    @Nullable
    private final CookieSameSite sameSite;

    /**
     * Cookie expiration date, session cookie if not set
     */
    @Nullable
    private final TimeSinceEpoch expires;

    /**
     * Cookie Priority type.
     */
    @Nullable
    @Experimental
    private final CookiePriority priority;

    /**
     * True if cookie is SameParty.
     */
    @Nullable
    @Experimental
    private final Boolean sameParty;

    /**
     * Cookie source scheme type.
     */
    @Nullable
    @Experimental
    private final CookieSourceScheme sourceScheme;

    /**
     * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port.
     * An unspecified port value allows protocol clients to emulate legacy cookie scope for the port.
     * This is a temporary ability and it will be removed in the future.
     */
    @Nullable
    @Experimental
    private final Integer sourcePort;

    /**
     * Cookie partition key. If not set, the cookie will be set as not partitioned.
     */
    @Nullable
    @Experimental
    private final CookiePartitionKey partitionKey;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCookieResponse {
    /**
     * Always set to true. If an error occurs, the response indicates protocol error.
     */
    @Deprecated
    private final Boolean success;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCookiesRequest {
    /**
     * Cookies to be set.
     */
    private final List<CookieParam> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetExtraHTTPHeadersRequest {
    /**
     * Map with extra HTTP headers.
     */
    private final Headers headers;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAttachDebugStackRequest {
    /**
     * Whether to attach a page script stack for debugging purpose.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetRequestInterceptionRequest {
    /**
     * Requests matching any of these patterns will be forwarded and wait for the corresponding
     * continueInterceptedRequest call.
     */
    private final List<RequestPattern> patterns;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetUserAgentOverrideRequest {
    /**
     * User agent to use.
     */
    private final String userAgent;

    /**
     * Browser language to emulate.
     */
    @Nullable
    private final String acceptLanguage;

    /**
     * The platform navigator.platform should return.
     */
    @Nullable
    private final String platform;

    /**
     * To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData
     */
    @Nullable
    @Experimental
    private final UserAgentMetadata userAgentMetadata;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StreamResourceContentRequest {
    /**
     * Identifier of the request to stream.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StreamResourceContentResponse {
    /**
     * Data that has been buffered until streaming is enabled. (Encoded as a base64 string when passed over JSON)
     */
    private final String bufferedData;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSecurityIsolationStatusRequest {
    /**
     * If no frameId is provided, the status of the target is provided.
     */
    @Nullable
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSecurityIsolationStatusResponse {
    private final SecurityIsolationStatus status;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableReportingApiRequest {
    /**
     * Whether to enable or disable events for the Reporting API
     */
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class LoadNetworkResourceRequest {
    /**
     * Frame id to get the resource for. Mandatory for frame targets, and
     * should be omitted for worker targets.
     */
    @Nullable
    private final FrameId frameId;

    /**
     * URL of the resource to get content for.
     */
    private final String url;

    /**
     * Options for the request.
     */
    private final LoadNetworkResourceOptions options;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class LoadNetworkResourceResponse {
    private final LoadNetworkResourcePageResult resource;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetCookieControlsRequest {
    /**
     * Whether 3pc restriction is enabled.
     */
    private final Boolean enableThirdPartyCookieRestriction;

    /**
     * Whether 3pc grace period exception should be enabled; false by default.
     */
    private final Boolean disableThirdPartyCookieMetadata;

    /**
     * Whether 3pc heuristics exceptions should be enabled; false by default.
     */
    private final Boolean disableThirdPartyCookieHeuristics;
  }
}
