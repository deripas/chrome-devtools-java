package io.github.deripas.chrome.devtools.api.memory;

import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class Memory {
  private final Session session;

  /**
   * Retruns current DOM object counters.
   */
  public CompletableFuture<GetDOMCountersResponse> getDOMCounters() {
    return session.send("Memory.getDOMCounters", null, GetDOMCountersResponse.class);
  }

  /**
   * Retruns DOM object counters after preparing renderer for leak detection.
   */
  public CompletableFuture<GetDOMCountersForLeakDetectionResponse> getDOMCountersForLeakDetection(
      ) {
    return session.send("Memory.getDOMCountersForLeakDetection", null, GetDOMCountersForLeakDetectionResponse.class);
  }

  /**
   * Prepares for leak detection by terminating workers, stopping spellcheckers,
   * dropping non-essential internal caches, running garbage collections, etc.
   */
  public CompletableFuture<Void> prepareForLeakDetection() {
    return session.send("Memory.prepareForLeakDetection", null, Void.class);
  }

  /**
   * Simulate OomIntervention by purging V8 memory.
   */
  public CompletableFuture<Void> forciblyPurgeJavaScriptMemory() {
    return session.send("Memory.forciblyPurgeJavaScriptMemory", null, Void.class);
  }

  /**
   * Enable/disable suppressing memory pressure notifications in all processes.
   */
  public CompletableFuture<Void> setPressureNotificationsSuppressed(
      SetPressureNotificationsSuppressedRequest request) {
    return session.send("Memory.setPressureNotificationsSuppressed", request, Void.class);
  }

  /**
   * Simulate a memory pressure notification in all processes.
   */
  public CompletableFuture<Void> simulatePressureNotification(
      SimulatePressureNotificationRequest request) {
    return session.send("Memory.simulatePressureNotification", request, Void.class);
  }

  /**
   * Start collecting native memory profile.
   */
  public CompletableFuture<Void> startSampling(StartSamplingRequest request) {
    return session.send("Memory.startSampling", request, Void.class);
  }

  /**
   * Stop collecting native memory profile.
   */
  public CompletableFuture<Void> stopSampling() {
    return session.send("Memory.stopSampling", null, Void.class);
  }

  /**
   * Retrieve native memory allocations profile
   * collected since renderer process startup.
   */
  public CompletableFuture<GetAllTimeSamplingProfileResponse> getAllTimeSamplingProfile() {
    return session.send("Memory.getAllTimeSamplingProfile", null, GetAllTimeSamplingProfileResponse.class);
  }

  /**
   * Retrieve native memory allocations profile
   * collected since browser process startup.
   */
  public CompletableFuture<GetBrowserSamplingProfileResponse> getBrowserSamplingProfile() {
    return session.send("Memory.getBrowserSamplingProfile", null, GetBrowserSamplingProfileResponse.class);
  }

  /**
   * Retrieve native memory allocations profile collected since last
   * `startSampling` call.
   */
  public CompletableFuture<GetSamplingProfileResponse> getSamplingProfile() {
    return session.send("Memory.getSamplingProfile", null, GetSamplingProfileResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDOMCountersResponse {
    private final Integer documents;

    private final Integer nodes;

    private final Integer jsEventListeners;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDOMCountersForLeakDetectionResponse {
    /**
     * DOM object counters.
     */
    private final List<DOMCounter> counters;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetPressureNotificationsSuppressedRequest {
    /**
     * If true, memory pressure notifications will be suppressed.
     */
    private final Boolean suppressed;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SimulatePressureNotificationRequest {
    /**
     * Memory pressure level of the notification.
     */
    private final PressureLevel level;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartSamplingRequest {
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
  public static class GetAllTimeSamplingProfileResponse {
    private final SamplingProfile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetBrowserSamplingProfileResponse {
    private final SamplingProfile profile;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSamplingProfileResponse {
    private final SamplingProfile profile;
  }
}
