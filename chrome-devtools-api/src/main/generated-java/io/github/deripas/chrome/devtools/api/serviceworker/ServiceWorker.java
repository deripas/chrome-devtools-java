package io.github.deripas.chrome.devtools.api.serviceworker;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface ServiceWorker {
  CompletableFuture<Void> deliverPushMessage(DeliverPushMessageRequest request);

  CompletableFuture<Void> disable();

  CompletableFuture<Void> dispatchSyncEvent(DispatchSyncEventRequest request);

  CompletableFuture<Void> dispatchPeriodicSyncEvent(DispatchPeriodicSyncEventRequest request);

  CompletableFuture<Void> enable();

  CompletableFuture<Void> inspectWorker(InspectWorkerRequest request);

  CompletableFuture<Void> setForceUpdateOnPageLoad(SetForceUpdateOnPageLoadRequest request);

  CompletableFuture<Void> skipWaiting(SkipWaitingRequest request);

  CompletableFuture<Void> startWorker(StartWorkerRequest request);

  CompletableFuture<Void> stopAllWorkers();

  CompletableFuture<Void> stopWorker(StopWorkerRequest request);

  CompletableFuture<Void> unregister(UnregisterRequest request);

  CompletableFuture<Void> updateRegistration(UpdateRegistrationRequest request);

  Disposable onWorkerErrorReported(Consumer<WorkerErrorReportedEvent> listener);

  Disposable onWorkerRegistrationUpdated(Consumer<WorkerRegistrationUpdatedEvent> listener);

  Disposable onWorkerVersionUpdated(Consumer<WorkerVersionUpdatedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class DeliverPushMessageRequest {
    private final String origin;

    private final RegistrationID registrationId;

    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DispatchSyncEventRequest {
    private final String origin;

    private final RegistrationID registrationId;

    private final String tag;

    private final Boolean lastChance;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DispatchPeriodicSyncEventRequest {
    private final String origin;

    private final RegistrationID registrationId;

    private final String tag;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class InspectWorkerRequest {
    private final String versionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetForceUpdateOnPageLoadRequest {
    private final Boolean forceUpdateOnPageLoad;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SkipWaitingRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartWorkerRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopWorkerRequest {
    private final String versionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UnregisterRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UpdateRegistrationRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("workerErrorReported")
  class WorkerErrorReportedEvent {
    private final ServiceWorkerErrorMessage errorMessage;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("workerRegistrationUpdated")
  class WorkerRegistrationUpdatedEvent {
    private final List<ServiceWorkerRegistration> registrations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("workerVersionUpdated")
  class WorkerVersionUpdatedEvent {
    private final List<ServiceWorkerVersion> versions;
  }
}
