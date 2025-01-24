package org.deripas.chrome.protocol.api.backgroundservice;

import java.lang.Boolean;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
}
