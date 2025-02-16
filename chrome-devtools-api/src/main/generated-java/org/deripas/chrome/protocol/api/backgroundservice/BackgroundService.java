package org.deripas.chrome.protocol.api.backgroundservice;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;

/**
 * Defines events for background web platform features.
 */
@Experimental
@Generated
public interface BackgroundService {
  /**
   * Enables event updates for the service.
   */
  CompletableFuture<Void> startObserving(StartObservingRequest request);

  /**
   * Disables event updates for the service.
   */
  CompletableFuture<Void> stopObserving(StopObservingRequest request);

  /**
   * Set the recording state for the service.
   */
  CompletableFuture<Void> setRecording(SetRecordingRequest request);

  /**
   * Clears all stored data for the service.
   */
  CompletableFuture<Void> clearEvents(ClearEventsRequest request);

  Disposable onRecordingStateChanged(Consumer<RecordingStateChangedEvent> listener);

  Disposable onBackgroundServiceEventReceived(
      Consumer<BackgroundServiceEventReceivedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class StartObservingRequest {
    private final ServiceName service;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopObservingRequest {
    private final ServiceName service;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetRecordingRequest {
    private final Boolean shouldRecord;

    private final ServiceName service;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ClearEventsRequest {
    private final ServiceName service;
  }

  /**
   * Called when the recording state for the service has been updated.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("recordingStateChanged")
  class RecordingStateChangedEvent {
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
  @JsonTypeName("backgroundServiceEventReceived")
  class BackgroundServiceEventReceivedEvent {
    private final BackgroundServiceEvent backgroundServiceEvent;
  }
}
