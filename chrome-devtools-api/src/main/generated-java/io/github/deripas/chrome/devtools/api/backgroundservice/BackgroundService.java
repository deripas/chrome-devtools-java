package io.github.deripas.chrome.devtools.api.backgroundservice;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Boolean;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * Defines events for background web platform features.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class BackgroundService {
  private final Session session;

  /**
   * Enables event updates for the service.
   */
  public CompletableFuture<Void> startObserving(StartObservingRequest request) {
    return session.send("BackgroundService.startObserving", request, Void.class);
  }

  /**
   * Disables event updates for the service.
   */
  public CompletableFuture<Void> stopObserving(StopObservingRequest request) {
    return session.send("BackgroundService.stopObserving", request, Void.class);
  }

  /**
   * Set the recording state for the service.
   */
  public CompletableFuture<Void> setRecording(SetRecordingRequest request) {
    return session.send("BackgroundService.setRecording", request, Void.class);
  }

  /**
   * Clears all stored data for the service.
   */
  public CompletableFuture<Void> clearEvents(ClearEventsRequest request) {
    return session.send("BackgroundService.clearEvents", request, Void.class);
  }

  public Disposable onRecordingStateChanged(Consumer<RecordingStateChangedEvent> listener) {
    return session.subscribe("BackgroundService.recordingStateChanged", listener, RecordingStateChangedEvent.class);
  }

  public Disposable onBackgroundServiceEventReceived(
      Consumer<BackgroundServiceEventReceivedEvent> listener) {
    return session.subscribe("BackgroundService.backgroundServiceEventReceived", listener, BackgroundServiceEventReceivedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartObservingRequest {
    private final ServiceName service;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StopObservingRequest {
    private final ServiceName service;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetRecordingRequest {
    private final Boolean shouldRecord;

    private final ServiceName service;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ClearEventsRequest {
    private final ServiceName service;
  }

  /**
   * Called when the recording state for the service has been updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class RecordingStateChangedEvent {
    private final Boolean isRecording;

    private final ServiceName service;
  }

  /**
   * Called with all existing backgroundServiceEvents when enabled, and all new
   * events afterwards if enabled and recording.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class BackgroundServiceEventReceivedEvent {
    private final BackgroundServiceEvent backgroundServiceEvent;
  }
}
