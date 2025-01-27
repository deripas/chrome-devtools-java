package org.deripas.chrome.protocol.api.network;

import java.lang.Double;
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
  private final Double requestTime;

  /**
   * Started resolving proxy.
   */
  private final Double proxyStart;

  /**
   * Finished resolving proxy.
   */
  private final Double proxyEnd;

  /**
   * Started DNS address resolve.
   */
  private final Double dnsStart;

  /**
   * Finished DNS address resolve.
   */
  private final Double dnsEnd;

  /**
   * Started connecting to the remote host.
   */
  private final Double connectStart;

  /**
   * Connected to the remote host.
   */
  private final Double connectEnd;

  /**
   * Started SSL handshake.
   */
  private final Double sslStart;

  /**
   * Finished SSL handshake.
   */
  private final Double sslEnd;

  /**
   * Started running ServiceWorker.
   */
  @Experimental
  private final Double workerStart;

  /**
   * Finished Starting ServiceWorker.
   */
  @Experimental
  private final Double workerReady;

  /**
   * Started fetch event.
   */
  @Experimental
  private final Double workerFetchStart;

  /**
   * Settled fetch event respondWith promise.
   */
  @Experimental
  private final Double workerRespondWithSettled;

  /**
   * Started ServiceWorker static routing source evaluation.
   */
  @Nullable
  @Experimental
  private final Double workerRouterEvaluationStart;

  /**
   * Started cache lookup when the source was evaluated to `cache`.
   */
  @Nullable
  @Experimental
  private final Double workerCacheLookupStart;

  /**
   * Started sending request.
   */
  private final Double sendStart;

  /**
   * Finished sending request.
   */
  private final Double sendEnd;

  /**
   * Time the server started pushing request.
   */
  @Experimental
  private final Double pushStart;

  /**
   * Time the server finished pushing request.
   */
  @Experimental
  private final Double pushEnd;

  /**
   * Started receiving response headers.
   */
  @Experimental
  private final Double receiveHeadersStart;

  /**
   * Finished receiving response headers.
   */
  private final Double receiveHeadersEnd;
}
