package org.deripas.chrome.protocol.api.profiler;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
public interface Profiler {
  void disable();

  void enable();

  /**
   * Collect coverage data for the current isolate. The coverage data may be incomplete due to
   * garbage collection.
   */
  CompletableFuture<GetBestEffortCoverageResponse> getBestEffortCoverage();

  /**
   * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
   */
  void setSamplingInterval(SetSamplingIntervalRequest request);

  void start();

  /**
   * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code
   * coverage may be incomplete. Enabling prevents running optimized code and resets execution
   * counters.
   */
  CompletableFuture<StartPreciseCoverageResponse> startPreciseCoverage(
      StartPreciseCoverageRequest request);

  CompletableFuture<StopResponse> stop();

  /**
   * Disable precise code coverage. Disabling releases unnecessary execution count records and allows
   * executing optimized code.
   */
  void stopPreciseCoverage();

  /**
   * Collect coverage data for the current isolate, and resets execution counters. Precise code
   * coverage needs to have started.
   */
  CompletableFuture<TakePreciseCoverageResponse> takePreciseCoverage();

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBestEffortCoverageResponse {
    /**
     * Coverage data for the current isolate.
     */
    private final List<ScriptCoverage> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSamplingIntervalRequest {
    /**
     * New sampling interval in microseconds.
     */
    private final Integer interval;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartPreciseCoverageRequest {
    /**
     * Collect accurate call counts beyond simple 'covered' or 'not covered'.
     */
    @Nullable
    private final Boolean callCount;

    /**
     * Collect block-based coverage.
     */
    @Nullable
    private final Boolean detailed;

    /**
     * Allow the backend to send updates on its own initiative
     */
    @Nullable
    private final Boolean allowTriggeredUpdates;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartPreciseCoverageResponse {
    /**
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
     */
    private final Long timestamp;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopResponse {
    /**
     * Recorded profile.
     */
    private final Profile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class TakePreciseCoverageResponse {
    /**
     * Coverage data for the current isolate.
     */
    private final List<ScriptCoverage> result;

    /**
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
     */
    private final Long timestamp;
  }
}
