package org.deripas.chrome.protocol.api.network;

import java.lang.Long;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Timing information for the request.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ResourceTiming {
  /**
   * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in
   * milliseconds relatively to this requestTime.
   */
  private final Long requestTime;

  /**
   * Started resolving proxy.
   */
  private final Long proxyStart;

  /**
   * Finished resolving proxy.
   */
  private final Long proxyEnd;

  /**
   * Started DNS address resolve.
   */
  private final Long dnsStart;

  /**
   * Finished DNS address resolve.
   */
  private final Long dnsEnd;

  /**
   * Started connecting to the remote host.
   */
  private final Long connectStart;

  /**
   * Connected to the remote host.
   */
  private final Long connectEnd;

  /**
   * Started SSL handshake.
   */
  private final Long sslStart;

  /**
   * Finished SSL handshake.
   */
  private final Long sslEnd;

  /**
   * Started running ServiceWorker.
   */
  @Experimental
  private final Long workerStart;

  /**
   * Finished Starting ServiceWorker.
   */
  @Experimental
  private final Long workerReady;

  /**
   * Started fetch event.
   */
  @Experimental
  private final Long workerFetchStart;

  /**
   * Settled fetch event respondWith promise.
   */
  @Experimental
  private final Long workerRespondWithSettled;

  /**
   * Started ServiceWorker static routing source evaluation.
   */
  @Nullable
  @Experimental
  private final Long workerRouterEvaluationStart;

  /**
   * Started cache lookup when the source was evaluated to `cache`.
   */
  @Nullable
  @Experimental
  private final Long workerCacheLookupStart;

  /**
   * Started sending request.
   */
  private final Long sendStart;

  /**
   * Finished sending request.
   */
  private final Long sendEnd;

  /**
   * Time the server started pushing request.
   */
  @Experimental
  private final Long pushStart;

  /**
   * Time the server finished pushing request.
   */
  @Experimental
  private final Long pushEnd;

  /**
   * Started receiving response headers.
   */
  @Experimental
  private final Long receiveHeadersStart;

  /**
   * Finished receiving response headers.
   */
  private final Long receiveHeadersEnd;
}
