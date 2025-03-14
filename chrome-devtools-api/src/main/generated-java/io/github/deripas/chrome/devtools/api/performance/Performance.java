package io.github.deripas.chrome.devtools.api.performance;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Deprecated;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Generated
public class Performance {
  private final Session session;

  /**
   * Disable collecting and reporting metrics.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Performance.disable", null, Void.class);
  }

  /**
   * Enable collecting and reporting metrics.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("Performance.enable", request, Void.class);
  }

  /**
   * Sets time domain to use for collecting and reporting duration metrics.
   * Note that this must be called before enabling metrics collection. Calling
   * this method while metrics collection is enabled returns an error.
   */
  @Deprecated
  public CompletableFuture<Void> setTimeDomain(SetTimeDomainRequest request) {
    return session.send("Performance.setTimeDomain", request, Void.class);
  }

  /**
   * Retrieve current values of run-time metrics.
   */
  public CompletableFuture<GetMetricsResponse> getMetrics() {
    return session.send("Performance.getMetrics", null, GetMetricsResponse.class);
  }

  public Disposable onMetrics(Consumer<MetricsEvent> listener) {
    return session.subscribe("Performance.metrics", listener, MetricsEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
    /**
     * Time domain to use for collecting and reporting duration metrics.
     */
    @Nullable
    private final TimeDomain timeDomain;

    public enum TimeDomain {
      @JsonProperty("timeTicks")
      TIME_TICKS,

      @JsonProperty("threadTicks")
      THREAD_TICKS
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetTimeDomainRequest {
    /**
     * Time domain
     */
    private final TimeDomain timeDomain;

    public enum TimeDomain {
      @JsonProperty("timeTicks")
      TIME_TICKS,

      @JsonProperty("threadTicks")
      THREAD_TICKS
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetMetricsResponse {
    /**
     * Current values for run-time metrics.
     */
    private final List<Metric> metrics;
  }

  /**
   * Current values of the metrics.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class MetricsEvent {
    /**
     * Current values of the metrics.
     */
    private final List<Metric> metrics;

    /**
     * Timestamp title.
     */
    private final String title;
  }
}
