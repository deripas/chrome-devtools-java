package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.debugger.SearchMatch;
import io.github.deripas.chrome.devtools.api.emulation.UserAgentMetadata;
import io.github.deripas.chrome.devtools.api.io.StreamHandle;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
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
 * Network domain allows tracking network activities of the page. It exposes information about http,
 * file, data and other requests and responses, their headers, bodies, timing, etc.
 */
@RequiredArgsConstructor
@Generated
public class Network {
  private final Session session;

  /**
   * Sets a list of content encodings that will be accepted. Empty list means no encoding is accepted.
   */
  public CompletableFuture<Void> setAcceptedEncodings(SetAcceptedEncodingsRequest request) {
    return session.send("Network.setAcceptedEncodings", request, Void.class);
  }

  /**
   * Clears accepted encodings set by setAcceptedEncodings
   */
  public CompletableFuture<Void> clearAcceptedEncodingsOverride() {
    return session.send("Network.clearAcceptedEncodingsOverride", null, Void.class);
  }

  /**
   * Tells whether clearing browser cache is supported.
   */
  @Deprecated
  public CompletableFuture<CanClearBrowserCacheResponse> canClearBrowserCache() {
    return session.send("Network.canClearBrowserCache", null, CanClearBrowserCacheResponse.class);
  }

  /**
   * Tells whether clearing browser cookies is supported.
   */
  @Deprecated
  public CompletableFuture<CanClearBrowserCookiesResponse> canClearBrowserCookies() {
    return session.send("Network.canClearBrowserCookies", null, CanClearBrowserCookiesResponse.class);
  }

  /**
   * Tells whether emulation of network conditions is supported.
   */
  @Deprecated
  public CompletableFuture<CanEmulateNetworkConditionsResponse> canEmulateNetworkConditions() {
    return session.send("Network.canEmulateNetworkConditions", null, CanEmulateNetworkConditionsResponse.class);
  }

  /**
   * Clears browser cache.
   */
  public CompletableFuture<Void> clearBrowserCache() {
    return session.send("Network.clearBrowserCache", null, Void.class);
  }

  /**
   * Clears browser cookies.
   */
  public CompletableFuture<Void> clearBrowserCookies() {
    return session.send("Network.clearBrowserCookies", null, Void.class);
  }

  /**
   * Response to Network.requestIntercepted which either modifies the request to continue with any
   * modifications, or blocks it, or completes it with the provided response bytes. If a network
   * fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
   * event will be sent with the same InterceptionId.
   * Deprecated, use Fetch.continueRequest, Fetch.fulfillRequest and Fetch.failRequest instead.
   */
  @Deprecated
  public CompletableFuture<Void> continueInterceptedRequest(
      ContinueInterceptedRequestRequest request) {
    return session.send("Network.continueInterceptedRequest", request, Void.class);
  }

  /**
   * Deletes browser cookies with matching name and url or domain/path/partitionKey pair.
   */
  public CompletableFuture<Void> deleteCookies(DeleteCookiesRequest request) {
    return session.send("Network.deleteCookies", request, Void.class);
  }

  /**
   * Disables network tracking, prevents network events from being sent to the client.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Network.disable", null, Void.class);
  }

  /**
   * Activates emulation of network conditions.
   */
  public CompletableFuture<Void> emulateNetworkConditions(EmulateNetworkConditionsRequest request) {
    return session.send("Network.emulateNetworkConditions", request, Void.class);
  }

  /**
   * Enables network tracking, network events will now be delivered to the client.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("Network.enable", request, Void.class);
  }

  /**
   * Returns all browser cookies. Depending on the backend support, will return detailed cookie
   * information in the `cookies` field.
   * Deprecated. Use Storage.getCookies instead.
   */
  @Deprecated
  public CompletableFuture<GetAllCookiesResponse> getAllCookies() {
    return session.send("Network.getAllCookies", null, GetAllCookiesResponse.class);
  }

  /**
   * Returns the DER-encoded certificate.
   */
  public CompletableFuture<GetCertificateResponse> getCertificate(GetCertificateRequest request) {
    return session.send("Network.getCertificate", request, GetCertificateResponse.class);
  }

  /**
   * Returns all browser cookies for the current URL. Depending on the backend support, will return
   * detailed cookie information in the `cookies` field.
   */
  public CompletableFuture<GetCookiesResponse> getCookies(GetCookiesRequest request) {
    return session.send("Network.getCookies", request, GetCookiesResponse.class);
  }

  /**
   * Returns content served for the given request.
   */
  public CompletableFuture<GetResponseBodyResponse> getResponseBody(
      GetResponseBodyRequest request) {
    return session.send("Network.getResponseBody", request, GetResponseBodyResponse.class);
  }

  /**
   * Returns post data sent with the request. Returns an error when no data was sent with the request.
   */
  public CompletableFuture<GetRequestPostDataResponse> getRequestPostData(
      GetRequestPostDataRequest request) {
    return session.send("Network.getRequestPostData", request, GetRequestPostDataResponse.class);
  }

  /**
   * Returns content served for the given currently intercepted request.
   */
  public CompletableFuture<GetResponseBodyForInterceptionResponse> getResponseBodyForInterception(
      GetResponseBodyForInterceptionRequest request) {
    return session.send("Network.getResponseBodyForInterception", request, GetResponseBodyForInterceptionResponse.class);
  }

  /**
   * Returns a handle to the stream representing the response body. Note that after this command,
   * the intercepted request can't be continued as is -- you either need to cancel it or to provide
   * the response body. The stream only supports sequential read, IO.read will fail if the position
   * is specified.
   */
  public CompletableFuture<TakeResponseBodyForInterceptionAsStreamResponse> takeResponseBodyForInterceptionAsStream(
      TakeResponseBodyForInterceptionAsStreamRequest request) {
    return session.send("Network.takeResponseBodyForInterceptionAsStream", request, TakeResponseBodyForInterceptionAsStreamResponse.class);
  }

  /**
   * This method sends a new XMLHttpRequest which is identical to the original one. The following
   * parameters should be identical: method, url, async, request body, extra headers, withCredentials
   * attribute, user, password.
   */
  public CompletableFuture<Void> replayXHR(ReplayXHRRequest request) {
    return session.send("Network.replayXHR", request, Void.class);
  }

  /**
   * Searches for given string in response content.
   */
  public CompletableFuture<SearchInResponseBodyResponse> searchInResponseBody(
      SearchInResponseBodyRequest request) {
    return session.send("Network.searchInResponseBody", request, SearchInResponseBodyResponse.class);
  }

  /**
   * Blocks URLs from loading.
   */
  public CompletableFuture<Void> setBlockedURLs(SetBlockedURLsRequest request) {
    return session.send("Network.setBlockedURLs", request, Void.class);
  }

  /**
   * Toggles ignoring of service worker for each request.
   */
  public CompletableFuture<Void> setBypassServiceWorker(SetBypassServiceWorkerRequest request) {
    return session.send("Network.setBypassServiceWorker", request, Void.class);
  }

  /**
   * Toggles ignoring cache for each request. If `true`, cache will not be used.
   */
  public CompletableFuture<Void> setCacheDisabled(SetCacheDisabledRequest request) {
    return session.send("Network.setCacheDisabled", request, Void.class);
  }

  /**
   * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
   */
  public CompletableFuture<SetCookieResponse> setCookie(SetCookieRequest request) {
    return session.send("Network.setCookie", request, SetCookieResponse.class);
  }

  /**
   * Sets given cookies.
   */
  public CompletableFuture<Void> setCookies(SetCookiesRequest request) {
    return session.send("Network.setCookies", request, Void.class);
  }

  /**
   * Specifies whether to always send extra HTTP headers with the requests from this page.
   */
  public CompletableFuture<Void> setExtraHTTPHeaders(SetExtraHTTPHeadersRequest request) {
    return session.send("Network.setExtraHTTPHeaders", request, Void.class);
  }

  /**
   * Specifies whether to attach a page script stack id in requests
   */
  public CompletableFuture<Void> setAttachDebugStack(SetAttachDebugStackRequest request) {
    return session.send("Network.setAttachDebugStack", request, Void.class);
  }

  /**
   * Sets the requests to intercept that match the provided patterns and optionally resource types.
   * Deprecated, please use Fetch.enable instead.
   */
  @Deprecated
  public CompletableFuture<Void> setRequestInterception(SetRequestInterceptionRequest request) {
    return session.send("Network.setRequestInterception", request, Void.class);
  }

  /**
   * Allows overriding user agent with the given string.
   */
  public CompletableFuture<Void> setUserAgentOverride(SetUserAgentOverrideRequest request) {
    return session.send("Network.setUserAgentOverride", request, Void.class);
  }

  /**
   * Enables streaming of the response for the given requestId.
   * If enabled, the dataReceived event contains the data that was received during streaming.
   */
  public CompletableFuture<StreamResourceContentResponse> streamResourceContent(
      StreamResourceContentRequest request) {
    return session.send("Network.streamResourceContent", request, StreamResourceContentResponse.class);
  }

  /**
   * Returns information about the COEP/COOP isolation status.
   */
  public CompletableFuture<GetSecurityIsolationStatusResponse> getSecurityIsolationStatus(
      GetSecurityIsolationStatusRequest request) {
    return session.send("Network.getSecurityIsolationStatus", request, GetSecurityIsolationStatusResponse.class);
  }

  /**
   * Enables tracking for the Reporting API, events generated by the Reporting API will now be delivered to the client.
   * Enabling triggers 'reportingApiReportAdded' for all existing reports.
   */
  public CompletableFuture<Void> enableReportingApi(EnableReportingApiRequest request) {
    return session.send("Network.enableReportingApi", request, Void.class);
  }

  /**
   * Fetches the resource and returns the content.
   */
  public CompletableFuture<LoadNetworkResourceResponse> loadNetworkResource(
      LoadNetworkResourceRequest request) {
    return session.send("Network.loadNetworkResource", request, LoadNetworkResourceResponse.class);
  }

  /**
   * Sets Controls for third-party cookie access
   * Page reload is required before the new cookie bahavior will be observed
   */
  public CompletableFuture<Void> setCookieControls(SetCookieControlsRequest request) {
    return session.send("Network.setCookieControls", request, Void.class);
  }

  public Disposable onDataReceived(Consumer<DataReceivedEvent> listener) {
    return session.subscribe("Network.dataReceived", listener, DataReceivedEvent.class);
  }

  public Disposable onEventSourceMessageReceived(
      Consumer<EventSourceMessageReceivedEvent> listener) {
    return session.subscribe("Network.eventSourceMessageReceived", listener, EventSourceMessageReceivedEvent.class);
  }

  public Disposable onLoadingFailed(Consumer<LoadingFailedEvent> listener) {
    return session.subscribe("Network.loadingFailed", listener, LoadingFailedEvent.class);
  }

  public Disposable onLoadingFinished(Consumer<LoadingFinishedEvent> listener) {
    return session.subscribe("Network.loadingFinished", listener, LoadingFinishedEvent.class);
  }

  public Disposable onRequestIntercepted(Consumer<RequestInterceptedEvent> listener) {
    return session.subscribe("Network.requestIntercepted", listener, RequestInterceptedEvent.class);
  }

  public Disposable onRequestServedFromCache(Consumer<RequestServedFromCacheEvent> listener) {
    return session.subscribe("Network.requestServedFromCache", listener, RequestServedFromCacheEvent.class);
  }

  public Disposable onRequestWillBeSent(Consumer<RequestWillBeSentEvent> listener) {
    return session.subscribe("Network.requestWillBeSent", listener, RequestWillBeSentEvent.class);
  }

  public Disposable onResourceChangedPriority(Consumer<ResourceChangedPriorityEvent> listener) {
    return session.subscribe("Network.resourceChangedPriority", listener, ResourceChangedPriorityEvent.class);
  }

  public Disposable onSignedExchangeReceived(Consumer<SignedExchangeReceivedEvent> listener) {
    return session.subscribe("Network.signedExchangeReceived", listener, SignedExchangeReceivedEvent.class);
  }

  public Disposable onResponseReceived(Consumer<ResponseReceivedEvent> listener) {
    return session.subscribe("Network.responseReceived", listener, ResponseReceivedEvent.class);
  }

  public Disposable onWebSocketClosed(Consumer<WebSocketClosedEvent> listener) {
    return session.subscribe("Network.webSocketClosed", listener, WebSocketClosedEvent.class);
  }

  public Disposable onWebSocketCreated(Consumer<WebSocketCreatedEvent> listener) {
    return session.subscribe("Network.webSocketCreated", listener, WebSocketCreatedEvent.class);
  }

  public Disposable onWebSocketFrameError(Consumer<WebSocketFrameErrorEvent> listener) {
    return session.subscribe("Network.webSocketFrameError", listener, WebSocketFrameErrorEvent.class);
  }

  public Disposable onWebSocketFrameReceived(Consumer<WebSocketFrameReceivedEvent> listener) {
    return session.subscribe("Network.webSocketFrameReceived", listener, WebSocketFrameReceivedEvent.class);
  }

  public Disposable onWebSocketFrameSent(Consumer<WebSocketFrameSentEvent> listener) {
    return session.subscribe("Network.webSocketFrameSent", listener, WebSocketFrameSentEvent.class);
  }

  public Disposable onWebSocketHandshakeResponseReceived(
      Consumer<WebSocketHandshakeResponseReceivedEvent> listener) {
    return session.subscribe("Network.webSocketHandshakeResponseReceived", listener, WebSocketHandshakeResponseReceivedEvent.class);
  }

  public Disposable onWebSocketWillSendHandshakeRequest(
      Consumer<WebSocketWillSendHandshakeRequestEvent> listener) {
    return session.subscribe("Network.webSocketWillSendHandshakeRequest", listener, WebSocketWillSendHandshakeRequestEvent.class);
  }

  public Disposable onWebTransportCreated(Consumer<WebTransportCreatedEvent> listener) {
    return session.subscribe("Network.webTransportCreated", listener, WebTransportCreatedEvent.class);
  }

  public Disposable onWebTransportConnectionEstablished(
      Consumer<WebTransportConnectionEstablishedEvent> listener) {
    return session.subscribe("Network.webTransportConnectionEstablished", listener, WebTransportConnectionEstablishedEvent.class);
  }

  public Disposable onWebTransportClosed(Consumer<WebTransportClosedEvent> listener) {
    return session.subscribe("Network.webTransportClosed", listener, WebTransportClosedEvent.class);
  }

  public Disposable onRequestWillBeSentExtraInfo(
      Consumer<RequestWillBeSentExtraInfoEvent> listener) {
    return session.subscribe("Network.requestWillBeSentExtraInfo", listener, RequestWillBeSentExtraInfoEvent.class);
  }

  public Disposable onResponseReceivedExtraInfo(Consumer<ResponseReceivedExtraInfoEvent> listener) {
    return session.subscribe("Network.responseReceivedExtraInfo", listener, ResponseReceivedExtraInfoEvent.class);
  }

  public Disposable onResponseReceivedEarlyHints(
      Consumer<ResponseReceivedEarlyHintsEvent> listener) {
    return session.subscribe("Network.responseReceivedEarlyHints", listener, ResponseReceivedEarlyHintsEvent.class);
  }

  public Disposable onTrustTokenOperationDone(Consumer<TrustTokenOperationDoneEvent> listener) {
    return session.subscribe("Network.trustTokenOperationDone", listener, TrustTokenOperationDoneEvent.class);
  }

  public Disposable onPolicyUpdated(Consumer<PolicyUpdatedEvent> listener) {
    return session.subscribe("Network.policyUpdated", listener, PolicyUpdatedEvent.class);
  }

  public Disposable onSubresourceWebBundleMetadataReceived(
      Consumer<SubresourceWebBundleMetadataReceivedEvent> listener) {
    return session.subscribe("Network.subresourceWebBundleMetadataReceived", listener, SubresourceWebBundleMetadataReceivedEvent.class);
  }

  public Disposable onSubresourceWebBundleMetadataError(
      Consumer<SubresourceWebBundleMetadataErrorEvent> listener) {
    return session.subscribe("Network.subresourceWebBundleMetadataError", listener, SubresourceWebBundleMetadataErrorEvent.class);
  }

  public Disposable onSubresourceWebBundleInnerResponseParsed(
      Consumer<SubresourceWebBundleInnerResponseParsedEvent> listener) {
    return session.subscribe("Network.subresourceWebBundleInnerResponseParsed", listener, SubresourceWebBundleInnerResponseParsedEvent.class);
  }

  public Disposable onSubresourceWebBundleInnerResponseError(
      Consumer<SubresourceWebBundleInnerResponseErrorEvent> listener) {
    return session.subscribe("Network.subresourceWebBundleInnerResponseError", listener, SubresourceWebBundleInnerResponseErrorEvent.class);
  }

  public Disposable onReportingApiReportAdded(Consumer<ReportingApiReportAddedEvent> listener) {
    return session.subscribe("Network.reportingApiReportAdded", listener, ReportingApiReportAddedEvent.class);
  }

  public Disposable onReportingApiReportUpdated(Consumer<ReportingApiReportUpdatedEvent> listener) {
    return session.subscribe("Network.reportingApiReportUpdated", listener, ReportingApiReportUpdatedEvent.class);
  }

  public Disposable onReportingApiEndpointsChangedForOrigin(
      Consumer<ReportingApiEndpointsChangedForOriginEvent> listener) {
    return session.subscribe("Network.reportingApiEndpointsChangedForOrigin", listener, ReportingApiEndpointsChangedForOriginEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAcceptedEncodingsRequest {
    /**
     * List of accepted content encodings.
     */
    private final List<ContentEncoding> encodings;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CanClearBrowserCacheResponse {
    /**
     * True if browser cache can be cleared.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CanClearBrowserCookiesResponse {
    /**
     * True if browser cookies can be cleared.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CanEmulateNetworkConditionsResponse {
    /**
     * True if emulation of network conditions is supported.
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ContinueInterceptedRequestRequest {
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
  public static class DeleteCookiesRequest {
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
  public static class EmulateNetworkConditionsRequest {
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
  public static class EnableRequest {
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
  public static class GetAllCookiesResponse {
    /**
     * Array of cookie objects.
     */
    private final List<Cookie> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCertificateRequest {
    /**
     * Origin to get certificate for.
     */
    private final String origin;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCertificateResponse {
    private final List<String> tableNames;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetCookiesRequest {
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
  public static class GetCookiesResponse {
    /**
     * Array of cookie objects.
     */
    private final List<Cookie> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResponseBodyRequest {
    /**
     * Identifier of the network request to get content for.
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
  public static class GetRequestPostDataRequest {
    /**
     * Identifier of the network request to get content for.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetRequestPostDataResponse {
    /**
     * Request body string, omitting files from multipart requests
     */
    private final String postData;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResponseBodyForInterceptionRequest {
    /**
     * Identifier for the intercepted request to get body for.
     */
    private final InterceptionId interceptionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResponseBodyForInterceptionResponse {
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
  public static class TakeResponseBodyForInterceptionAsStreamRequest {
    private final InterceptionId interceptionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TakeResponseBodyForInterceptionAsStreamResponse {
    private final StreamHandle stream;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReplayXHRRequest {
    /**
     * Identifier of XHR to replay.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SearchInResponseBodyRequest {
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
  public static class SearchInResponseBodyResponse {
    /**
     * List of search matches.
     */
    private final List<SearchMatch> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBlockedURLsRequest {
    /**
     * URL patterns to block. Wildcards ('*') are allowed.
     */
    private final List<String> urls;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBypassServiceWorkerRequest {
    /**
     * Bypass service worker and load from network.
     */
    private final Boolean bypass;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetCacheDisabledRequest {
    /**
     * Cache disabled state.
     */
    private final Boolean cacheDisabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetCookieRequest {
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
  public static class SetCookieResponse {
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
  public static class SetCookiesRequest {
    /**
     * Cookies to be set.
     */
    private final List<CookieParam> cookies;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetExtraHTTPHeadersRequest {
    /**
     * Map with extra HTTP headers.
     */
    private final Headers headers;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAttachDebugStackRequest {
    /**
     * Whether to attach a page script stack for debugging purpose.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetRequestInterceptionRequest {
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
  public static class SetUserAgentOverrideRequest {
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
  public static class StreamResourceContentRequest {
    /**
     * Identifier of the request to stream.
     */
    private final RequestId requestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StreamResourceContentResponse {
    /**
     * Data that has been buffered until streaming is enabled. (Encoded as a base64 string when passed over JSON)
     */
    private final String bufferedData;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSecurityIsolationStatusRequest {
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
  public static class GetSecurityIsolationStatusResponse {
    private final SecurityIsolationStatus status;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableReportingApiRequest {
    /**
     * Whether to enable or disable events for the Reporting API
     */
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadNetworkResourceRequest {
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
  public static class LoadNetworkResourceResponse {
    private final LoadNetworkResourcePageResult resource;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetCookieControlsRequest {
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

  /**
   * Fired when data chunk was received over the network.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DataReceivedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * Data chunk length.
     */
    private final Integer dataLength;

    /**
     * Actual bytes received (might be less than dataLength for compressed encodings).
     */
    private final Integer encodedDataLength;

    /**
     * Data that was received. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    @Experimental
    private final String data;
  }

  /**
   * Fired when EventSource message is received.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class EventSourceMessageReceivedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * Message type.
     */
    private final String eventName;

    /**
     * Message identifier.
     */
    private final String eventId;

    /**
     * Message content.
     */
    private final String data;
  }

  /**
   * Fired when HTTP request has failed to load.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadingFailedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * Resource type.
     */
    private final ResourceType type;

    /**
     * Error message. List of network errors: https://cs.chromium.org/chromium/src/net/base/net_error_list.h
     */
    private final String errorText;

    /**
     * True if loading was canceled.
     */
    @Nullable
    private final Boolean canceled;

    /**
     * The reason why loading was blocked, if any.
     */
    @Nullable
    private final BlockedReason blockedReason;

    /**
     * The reason why loading was blocked by CORS, if any.
     */
    @Nullable
    private final CorsErrorStatus corsErrorStatus;
  }

  /**
   * Fired when HTTP request has finished loading.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadingFinishedEvent {
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
    private final Double encodedDataLength;
  }

  /**
   * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
   * mocked.
   * Deprecated, use Fetch.requestPaused instead.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestInterceptedEvent {
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

  /**
   * Fired if request ended up loading from cache.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestServedFromCacheEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;
  }

  /**
   * Fired when page is about to send HTTP request.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestWillBeSentEvent {
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

  /**
   * Fired when resource loading priority is changed
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResourceChangedPriorityEvent {
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

  /**
   * Fired when a signed exchange was received over the network
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class SignedExchangeReceivedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Information about the signed exchange response.
     */
    private final SignedExchangeInfo info;
  }

  /**
   * Fired when HTTP response is available.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResponseReceivedEvent {
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

  /**
   * Fired when WebSocket is closed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketClosedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;
  }

  /**
   * Fired upon WebSocket creation.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketCreatedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * WebSocket request URL.
     */
    private final String url;

    /**
     * Request initiator.
     */
    @Nullable
    private final Initiator initiator;
  }

  /**
   * Fired when WebSocket message error occurs.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketFrameErrorEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * WebSocket error message.
     */
    private final String errorMessage;
  }

  /**
   * Fired when WebSocket message is received.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketFrameReceivedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * WebSocket response data.
     */
    private final WebSocketFrame response;
  }

  /**
   * Fired when WebSocket message is sent.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketFrameSentEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * WebSocket response data.
     */
    private final WebSocketFrame response;
  }

  /**
   * Fired when WebSocket handshake response becomes available.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketHandshakeResponseReceivedEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * WebSocket response data.
     */
    private final WebSocketResponse response;
  }

  /**
   * Fired when WebSocket is about to initiate handshake.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebSocketWillSendHandshakeRequestEvent {
    /**
     * Request identifier.
     */
    private final RequestId requestId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * UTC Timestamp.
     */
    private final TimeSinceEpoch wallTime;

    /**
     * WebSocket request data.
     */
    private final WebSocketRequest request;
  }

  /**
   * Fired upon WebTransport creation.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebTransportCreatedEvent {
    /**
     * WebTransport identifier.
     */
    private final RequestId transportId;

    /**
     * WebTransport request URL.
     */
    private final String url;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;

    /**
     * Request initiator.
     */
    @Nullable
    private final Initiator initiator;
  }

  /**
   * Fired when WebTransport handshake is finished.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebTransportConnectionEstablishedEvent {
    /**
     * WebTransport identifier.
     */
    private final RequestId transportId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;
  }

  /**
   * Fired when WebTransport is disposed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WebTransportClosedEvent {
    /**
     * WebTransport identifier.
     */
    private final RequestId transportId;

    /**
     * Timestamp.
     */
    private final MonotonicTime timestamp;
  }

  /**
   * Fired when additional information about a requestWillBeSent event is available from the
   * network stack. Not every requestWillBeSent event will have an additional
   * requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
   * or requestWillBeSentExtraInfo will be fired first for the same request.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestWillBeSentExtraInfoEvent {
    /**
     * Request identifier. Used to match this information to an existing requestWillBeSent event.
     */
    private final RequestId requestId;

    /**
     * A list of cookies potentially associated to the requested URL. This includes both cookies sent with
     * the request and the ones not sent; the latter are distinguished by having blockedReasons field set.
     */
    private final List<AssociatedCookie> associatedCookies;

    /**
     * Raw request headers as they will be sent over the wire.
     */
    private final Headers headers;

    /**
     * Connection timing information for the request.
     */
    @Experimental
    private final ConnectTiming connectTiming;

    /**
     * The client security state set for the request.
     */
    @Nullable
    private final ClientSecurityState clientSecurityState;

    /**
     * Whether the site has partitioned cookies stored in a partition different than the current one.
     */
    @Nullable
    private final Boolean siteHasCookieInOtherPartition;
  }

  /**
   * Fired when additional information about a responseReceived event is available from the network
   * stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
   * it, and responseReceivedExtraInfo may be fired before or after responseReceived.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResponseReceivedExtraInfoEvent {
    /**
     * Request identifier. Used to match this information to another responseReceived event.
     */
    private final RequestId requestId;

    /**
     * A list of cookies which were not stored from the response along with the corresponding
     * reasons for blocking. The cookies here may not be valid due to syntax errors, which
     * are represented by the invalid cookie line string instead of a proper cookie.
     */
    private final List<BlockedSetCookieWithReason> blockedCookies;

    /**
     * Raw response headers as they were received over the wire.
     * Duplicate headers in the response are represented as a single key with their values
     * concatentated using `\n` as the separator.
     * See also `headersText` that contains verbatim text for HTTP/1.*.
     */
    private final Headers headers;

    /**
     * The IP address space of the resource. The address space can only be determined once the transport
     * established the connection, so we can't send it in `requestWillBeSentExtraInfo`.
     */
    private final IPAddressSpace resourceIPAddressSpace;

    /**
     * The status code of the response. This is useful in cases the request failed and no responseReceived
     * event is triggered, which is the case for, e.g., CORS errors. This is also the correct status code
     * for cached requests, where the status in responseReceived is a 200 and this will be 304.
     */
    private final Integer statusCode;

    /**
     * Raw response header text as it was received over the wire. The raw text may not always be
     * available, such as in the case of HTTP/2 or QUIC.
     */
    @Nullable
    private final String headersText;

    /**
     * The cookie partition key that will be used to store partitioned cookies set in this response.
     * Only sent when partitioned cookies are enabled.
     */
    @Nullable
    @Experimental
    private final CookiePartitionKey cookiePartitionKey;

    /**
     * True if partitioned cookies are enabled, but the partition key is not serializable to string.
     */
    @Nullable
    private final Boolean cookiePartitionKeyOpaque;

    /**
     * A list of cookies which should have been blocked by 3PCD but are exempted and stored from
     * the response with the corresponding reason.
     */
    @Nullable
    private final List<ExemptedSetCookieWithReason> exemptedCookies;
  }

  /**
   * Fired when 103 Early Hints headers is received in addition to the common response.
   * Not every responseReceived event will have an responseReceivedEarlyHints fired.
   * Only one responseReceivedEarlyHints may be fired for eached responseReceived event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResponseReceivedEarlyHintsEvent {
    /**
     * Request identifier. Used to match this information to another responseReceived event.
     */
    private final RequestId requestId;

    /**
     * Raw response headers as they were received over the wire.
     * Duplicate headers in the response are represented as a single key with their values
     * concatentated using `\n` as the separator.
     * See also `headersText` that contains verbatim text for HTTP/1.*.
     */
    private final Headers headers;
  }

  /**
   * Fired exactly once for each Trust Token operation. Depending on
   * the type of the operation and whether the operation succeeded or
   * failed, the event is fired before the corresponding request was sent
   * or after the response was received.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class TrustTokenOperationDoneEvent {
    /**
     * Detailed success or error status of the operation.
     * 'AlreadyExists' also signifies a successful operation, as the result
     * of the operation already exists und thus, the operation was abort
     * preemptively (e.g. a cache hit).
     */
    private final Status status;

    private final TrustTokenOperationType type;

    private final RequestId requestId;

    /**
     * Top level origin. The context in which the operation was attempted.
     */
    @Nullable
    private final String topLevelOrigin;

    /**
     * Origin of the issuer in case of a "Issuance" or "Redemption" operation.
     */
    @Nullable
    private final String issuerOrigin;

    /**
     * The number of obtained Trust Tokens on a successful "Issuance" operation.
     */
    @Nullable
    private final Integer issuedTokenCount;

    public enum Status {
      @JsonProperty("Ok")
      OK,

      @JsonProperty("InvalidArgument")
      INVALID_ARGUMENT,

      @JsonProperty("MissingIssuerKeys")
      MISSING_ISSUER_KEYS,

      @JsonProperty("FailedPrecondition")
      FAILED_PRECONDITION,

      @JsonProperty("ResourceExhausted")
      RESOURCE_EXHAUSTED,

      @JsonProperty("AlreadyExists")
      ALREADY_EXISTS,

      @JsonProperty("ResourceLimited")
      RESOURCE_LIMITED,

      @JsonProperty("Unauthorized")
      UNAUTHORIZED,

      @JsonProperty("BadResponse")
      BAD_RESPONSE,

      @JsonProperty("InternalError")
      INTERNAL_ERROR,

      @JsonProperty("UnknownError")
      UNKNOWN_ERROR,

      @JsonProperty("FulfilledLocally")
      FULFILLED_LOCALLY,

      @JsonProperty("SiteIssuerLimit")
      SITE_ISSUER_LIMIT
    }
  }

  /**
   * Fired once security policy has been updated.
   */
  public static class PolicyUpdatedEvent {
  }

  /**
   * Fired once when parsing the .wbn file has succeeded.
   * The event contains the information about the web bundle contents.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class SubresourceWebBundleMetadataReceivedEvent {
    /**
     * Request identifier. Used to match this information to another event.
     */
    private final RequestId requestId;

    /**
     * A list of URLs of resources in the subresource Web Bundle.
     */
    private final List<String> urls;
  }

  /**
   * Fired once when parsing the .wbn file has failed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class SubresourceWebBundleMetadataErrorEvent {
    /**
     * Request identifier. Used to match this information to another event.
     */
    private final RequestId requestId;

    /**
     * Error message
     */
    private final String errorMessage;
  }

  /**
   * Fired when handling requests for resources within a .wbn file.
   * Note: this will only be fired for resources that are requested by the webpage.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class SubresourceWebBundleInnerResponseParsedEvent {
    /**
     * Request identifier of the subresource request
     */
    private final RequestId innerRequestId;

    /**
     * URL of the subresource resource.
     */
    private final String innerRequestURL;

    /**
     * Bundle request identifier. Used to match this information to another event.
     * This made be absent in case when the instrumentation was enabled only
     * after webbundle was parsed.
     */
    @Nullable
    private final RequestId bundleRequestId;
  }

  /**
   * Fired when request for resources within a .wbn file failed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class SubresourceWebBundleInnerResponseErrorEvent {
    /**
     * Request identifier of the subresource request
     */
    private final RequestId innerRequestId;

    /**
     * URL of the subresource resource.
     */
    private final String innerRequestURL;

    /**
     * Error message
     */
    private final String errorMessage;

    /**
     * Bundle request identifier. Used to match this information to another event.
     * This made be absent in case when the instrumentation was enabled only
     * after webbundle was parsed.
     */
    @Nullable
    private final RequestId bundleRequestId;
  }

  /**
   * Is sent whenever a new report is added.
   * And after 'enableReportingApi' for all existing reports.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReportingApiReportAddedEvent {
    private final ReportingApiReport report;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReportingApiReportUpdatedEvent {
    private final ReportingApiReport report;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReportingApiEndpointsChangedForOriginEvent {
    /**
     * Origin of the document(s) which configured the endpoints.
     */
    private final String origin;

    private final List<ReportingApiEndpoint> endpoints;
  }
}
