package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.security.SecurityState;

/**
 * HTTP response data.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Response {
  /**
   * Response URL. This URL can be different from CachedResource.url in case of redirect.
   */
  private final String url;

  /**
   * HTTP response status code.
   */
  private final Integer status;

  /**
   * HTTP response status text.
   */
  private final String statusText;

  /**
   * HTTP response headers.
   */
  private final Headers headers;

  /**
   * HTTP response headers text. This has been replaced by the headers in Network.responseReceivedExtraInfo.
   */
  @Nullable
  @Deprecated
  private final String headersText;

  /**
   * Resource mimeType as determined by the browser.
   */
  private final String mimeType;

  /**
   * Resource charset as determined by the browser (if applicable).
   */
  private final String charset;

  /**
   * Refined HTTP request headers that were actually transmitted over the network.
   */
  @Nullable
  private final Headers requestHeaders;

  /**
   * HTTP request headers text. This has been replaced by the headers in Network.requestWillBeSentExtraInfo.
   */
  @Nullable
  @Deprecated
  private final String requestHeadersText;

  /**
   * Specifies whether physical connection was actually reused for this request.
   */
  private final Boolean connectionReused;

  /**
   * Physical connection id that was actually used for this request.
   */
  private final Long connectionId;

  /**
   * Remote IP address.
   */
  @Nullable
  private final String remoteIPAddress;

  /**
   * Remote port.
   */
  @Nullable
  private final Integer remotePort;

  /**
   * Specifies that the request was served from the disk cache.
   */
  @Nullable
  private final Boolean fromDiskCache;

  /**
   * Specifies that the request was served from the ServiceWorker.
   */
  @Nullable
  private final Boolean fromServiceWorker;

  /**
   * Specifies that the request was served from the prefetch cache.
   */
  @Nullable
  private final Boolean fromPrefetchCache;

  /**
   * Specifies that the request was served from the prefetch cache.
   */
  @Nullable
  private final Boolean fromEarlyHints;

  /**
   * Information about how ServiceWorker Static Router API was used. If this
   * field is set with `matchedSourceType` field, a matching rule is found.
   * If this field is set without `matchedSource`, no matching rule is found.
   * Otherwise, the API is not used.
   */
  @Nullable
  @Experimental
  private final ServiceWorkerRouterInfo serviceWorkerRouterInfo;

  /**
   * Total number of bytes received for this request so far.
   */
  private final Long encodedDataLength;

  /**
   * Timing information for the given request.
   */
  @Nullable
  private final ResourceTiming timing;

  /**
   * Response source of response from ServiceWorker.
   */
  @Nullable
  private final ServiceWorkerResponseSource serviceWorkerResponseSource;

  /**
   * The time at which the returned response was generated.
   */
  @Nullable
  private final TimeSinceEpoch responseTime;

  /**
   * Cache Storage Cache Name.
   */
  @Nullable
  private final String cacheStorageCacheName;

  /**
   * Protocol used to fetch this request.
   */
  @Nullable
  private final String protocol;

  /**
   * The reason why Chrome uses a specific transport protocol for HTTP semantics.
   */
  @Nullable
  @Experimental
  private final AlternateProtocolUsage alternateProtocolUsage;

  /**
   * Security state of the request resource.
   */
  private final SecurityState securityState;

  /**
   * Security details for the request.
   */
  @Nullable
  private final SecurityDetails securityDetails;
}
