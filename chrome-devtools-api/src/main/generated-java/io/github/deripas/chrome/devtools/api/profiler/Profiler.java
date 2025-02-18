package io.github.deripas.chrome.devtools.api.profiler;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.debugger.Location;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
public interface Profiler {
  CompletableFuture<Void> disable();

  CompletableFuture<Void> enable();

  /**
   * Collect coverage data for the current isolate. The coverage data may be incomplete due to
   * garbage collection.
   */
  CompletableFuture<GetBestEffortCoverageResponse> getBestEffortCoverage();

  /**
   * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
   */
  CompletableFuture<Void> setSamplingInterval(SetSamplingIntervalRequest request);

  CompletableFuture<Void> start();

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
  CompletableFuture<Void> stopPreciseCoverage();

  /**
   * Collect coverage data for the current isolate, and resets execution counters. Precise code
   * coverage needs to have started.
   */
  CompletableFuture<TakePreciseCoverageResponse> takePreciseCoverage();

  Disposable onConsoleProfileFinished(Consumer<ConsoleProfileFinishedEvent> listener);

  Disposable onConsoleProfileStarted(Consumer<ConsoleProfileStartedEvent> listener);

  Disposable onPreciseCoverageDeltaUpdate(Consumer<PreciseCoverageDeltaUpdateEvent> listener);

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
    private final Double timestamp;
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
    private final Double timestamp;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("consoleProfileFinished")
  class ConsoleProfileFinishedEvent {
    private final String id;

    /**
     * Location of console.profileEnd().
     */
    private final Location location;

    private final Profile profile;

    /**
     * Profile title passed as an argument to console.profile().
     */
    @Nullable
    private final String title;
  }

  /**
   * Sent when new profile recording is started using console.profile() call.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("consoleProfileStarted")
  class ConsoleProfileStartedEvent {
    private final String id;

    /**
     * Location of console.profile().
     */
    private final Location location;

    /**
     * Profile title passed as an argument to console.profile().
     */
    @Nullable
    private final String title;
  }

  /**
   * Reports coverage delta since the last poll (either from an event like this, or from
   * `takePreciseCoverage` for the current isolate. May only be sent if precise code
   * coverage has been started. This event can be trigged by the embedder to, for example,
   * trigger collection of coverage data immediately at a certain point in time.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("preciseCoverageDeltaUpdate")
  class PreciseCoverageDeltaUpdateEvent {
    /**
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
     */
    private final Double timestamp;

    /**
     * Identifier for distinguishing coverage events.
     */
    private final String occasion;

    /**
     * Coverage data for the current isolate.
     */
    private final List<ScriptCoverage> result;
  }
}
