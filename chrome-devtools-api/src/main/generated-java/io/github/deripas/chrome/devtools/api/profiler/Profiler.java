package io.github.deripas.chrome.devtools.api.profiler;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Generated
public class Profiler {
  private final Session session;

  public CompletableFuture<Void> disable() {
    return session.send("Profiler.disable", null, Void.class);
  }

  public CompletableFuture<Void> enable() {
    return session.send("Profiler.enable", null, Void.class);
  }

  /**
   * Collect coverage data for the current isolate. The coverage data may be incomplete due to
   * garbage collection.
   */
  public CompletableFuture<GetBestEffortCoverageResponse> getBestEffortCoverage() {
    return session.send("Profiler.getBestEffortCoverage", null, GetBestEffortCoverageResponse.class);
  }

  /**
   * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
   */
  public CompletableFuture<Void> setSamplingInterval(SetSamplingIntervalRequest request) {
    return session.send("Profiler.setSamplingInterval", request, Void.class);
  }

  public CompletableFuture<Void> start() {
    return session.send("Profiler.start", null, Void.class);
  }

  /**
   * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code
   * coverage may be incomplete. Enabling prevents running optimized code and resets execution
   * counters.
   */
  public CompletableFuture<StartPreciseCoverageResponse> startPreciseCoverage(
      StartPreciseCoverageRequest request) {
    return session.send("Profiler.startPreciseCoverage", request, StartPreciseCoverageResponse.class);
  }

  public CompletableFuture<StopResponse> stop() {
    return session.send("Profiler.stop", null, StopResponse.class);
  }

  /**
   * Disable precise code coverage. Disabling releases unnecessary execution count records and allows
   * executing optimized code.
   */
  public CompletableFuture<Void> stopPreciseCoverage() {
    return session.send("Profiler.stopPreciseCoverage", null, Void.class);
  }

  /**
   * Collect coverage data for the current isolate, and resets execution counters. Precise code
   * coverage needs to have started.
   */
  public CompletableFuture<TakePreciseCoverageResponse> takePreciseCoverage() {
    return session.send("Profiler.takePreciseCoverage", null, TakePreciseCoverageResponse.class);
  }

  public Disposable onConsoleProfileFinished(Consumer<ConsoleProfileFinishedEvent> listener) {
    return session.subscribe("Profiler.consoleProfileFinished", listener, ConsoleProfileFinishedEvent.class);
  }

  public Disposable onConsoleProfileStarted(Consumer<ConsoleProfileStartedEvent> listener) {
    return session.subscribe("Profiler.consoleProfileStarted", listener, ConsoleProfileStartedEvent.class);
  }

  public Disposable onPreciseCoverageDeltaUpdate(
      Consumer<PreciseCoverageDeltaUpdateEvent> listener) {
    return session.subscribe("Profiler.preciseCoverageDeltaUpdate", listener, PreciseCoverageDeltaUpdateEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetBestEffortCoverageResponse {
    /**
     * Coverage data for the current isolate.
     */
    private final List<ScriptCoverage> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSamplingIntervalRequest {
    /**
     * New sampling interval in microseconds.
     */
    private final Integer interval;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartPreciseCoverageRequest {
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
  public static class StartPreciseCoverageResponse {
    /**
     * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
     */
    private final Double timestamp;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StopResponse {
    /**
     * Recorded profile.
     */
    private final Profile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class TakePreciseCoverageResponse {
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
  public static class ConsoleProfileFinishedEvent {
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
  public static class ConsoleProfileStartedEvent {
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
  public static class PreciseCoverageDeltaUpdateEvent {
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
