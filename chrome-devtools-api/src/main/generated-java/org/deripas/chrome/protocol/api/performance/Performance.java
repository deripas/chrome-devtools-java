package org.deripas.chrome.protocol.api.performance;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Deprecated;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
public interface Performance {
  /**
   * Disable collecting and reporting metrics.
   */
  CompletableFuture<Void> disable();

  /**
   * Enable collecting and reporting metrics.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Sets time domain to use for collecting and reporting duration metrics.
   * Note that this must be called before enabling metrics collection. Calling
   * this method while metrics collection is enabled returns an error.
   */
  @Deprecated
  CompletableFuture<Void> setTimeDomain(SetTimeDomainRequest request);

  /**
   * Retrieve current values of run-time metrics.
   */
  CompletableFuture<GetMetricsResponse> getMetrics();

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
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
  class SetTimeDomainRequest {
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
  class GetMetricsResponse {
    /**
     * Current values for run-time metrics.
     */
    private final List<Metric> metrics;
  }
}
