package io.github.deripas.chrome.devtools.api.memory;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface Memory {
  /**
   * Retruns current DOM object counters.
   */
  CompletableFuture<GetDOMCountersResponse> getDOMCounters();

  /**
   * Retruns DOM object counters after preparing renderer for leak detection.
   */
  CompletableFuture<GetDOMCountersForLeakDetectionResponse> getDOMCountersForLeakDetection();

  /**
   * Prepares for leak detection by terminating workers, stopping spellcheckers,
   * dropping non-essential internal caches, running garbage collections, etc.
   */
  CompletableFuture<Void> prepareForLeakDetection();

  /**
   * Simulate OomIntervention by purging V8 memory.
   */
  CompletableFuture<Void> forciblyPurgeJavaScriptMemory();

  /**
   * Enable/disable suppressing memory pressure notifications in all processes.
   */
  CompletableFuture<Void> setPressureNotificationsSuppressed(
      SetPressureNotificationsSuppressedRequest request);

  /**
   * Simulate a memory pressure notification in all processes.
   */
  CompletableFuture<Void> simulatePressureNotification(SimulatePressureNotificationRequest request);

  /**
   * Start collecting native memory profile.
   */
  CompletableFuture<Void> startSampling(StartSamplingRequest request);

  /**
   * Stop collecting native memory profile.
   */
  CompletableFuture<Void> stopSampling();

  /**
   * Retrieve native memory allocations profile
   * collected since renderer process startup.
   */
  CompletableFuture<GetAllTimeSamplingProfileResponse> getAllTimeSamplingProfile();

  /**
   * Retrieve native memory allocations profile
   * collected since browser process startup.
   */
  CompletableFuture<GetBrowserSamplingProfileResponse> getBrowserSamplingProfile();

  /**
   * Retrieve native memory allocations profile collected since last
   * `startSampling` call.
   */
  CompletableFuture<GetSamplingProfileResponse> getSamplingProfile();

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDOMCountersResponse {
    private final Integer documents;

    private final Integer nodes;

    private final Integer jsEventListeners;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDOMCountersForLeakDetectionResponse {
    /**
     * DOM object counters.
     */
    private final List<DOMCounter> counters;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPressureNotificationsSuppressedRequest {
    /**
     * If true, memory pressure notifications will be suppressed.
     */
    private final Boolean suppressed;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SimulatePressureNotificationRequest {
    /**
     * Memory pressure level of the notification.
     */
    private final PressureLevel level;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartSamplingRequest {
    /**
     * Average number of bytes between samples.
     */
    @Nullable
    private final Integer samplingInterval;

    /**
     * Do not randomize intervals between samples.
     */
    @Nullable
    private final Boolean suppressRandomness;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAllTimeSamplingProfileResponse {
    private final SamplingProfile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBrowserSamplingProfileResponse {
    private final SamplingProfile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSamplingProfileResponse {
    private final SamplingProfile profile;
  }
}
