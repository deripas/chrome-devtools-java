package io.github.deripas.chrome.devtools.api.serviceworker;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class ServiceWorker {
  private final Session session;

  public CompletableFuture<Void> deliverPushMessage(DeliverPushMessageRequest request) {
    return session.send("ServiceWorker.deliverPushMessage", request, Void.class);
  }

  public CompletableFuture<Void> disable() {
    return session.send("ServiceWorker.disable", null, Void.class);
  }

  public CompletableFuture<Void> dispatchSyncEvent(DispatchSyncEventRequest request) {
    return session.send("ServiceWorker.dispatchSyncEvent", request, Void.class);
  }

  public CompletableFuture<Void> dispatchPeriodicSyncEvent(
      DispatchPeriodicSyncEventRequest request) {
    return session.send("ServiceWorker.dispatchPeriodicSyncEvent", request, Void.class);
  }

  public CompletableFuture<Void> enable() {
    return session.send("ServiceWorker.enable", null, Void.class);
  }

  public CompletableFuture<Void> inspectWorker(InspectWorkerRequest request) {
    return session.send("ServiceWorker.inspectWorker", request, Void.class);
  }

  public CompletableFuture<Void> setForceUpdateOnPageLoad(SetForceUpdateOnPageLoadRequest request) {
    return session.send("ServiceWorker.setForceUpdateOnPageLoad", request, Void.class);
  }

  public CompletableFuture<Void> skipWaiting(SkipWaitingRequest request) {
    return session.send("ServiceWorker.skipWaiting", request, Void.class);
  }

  public CompletableFuture<Void> startWorker(StartWorkerRequest request) {
    return session.send("ServiceWorker.startWorker", request, Void.class);
  }

  public CompletableFuture<Void> stopAllWorkers() {
    return session.send("ServiceWorker.stopAllWorkers", null, Void.class);
  }

  public CompletableFuture<Void> stopWorker(StopWorkerRequest request) {
    return session.send("ServiceWorker.stopWorker", request, Void.class);
  }

  public CompletableFuture<Void> unregister(UnregisterRequest request) {
    return session.send("ServiceWorker.unregister", request, Void.class);
  }

  public CompletableFuture<Void> updateRegistration(UpdateRegistrationRequest request) {
    return session.send("ServiceWorker.updateRegistration", request, Void.class);
  }

  public Disposable onWorkerErrorReported(Consumer<WorkerErrorReportedEvent> listener) {
    return session.subscribe("ServiceWorker.workerErrorReported", listener, WorkerErrorReportedEvent.class);
  }

  public Disposable onWorkerRegistrationUpdated(Consumer<WorkerRegistrationUpdatedEvent> listener) {
    return session.subscribe("ServiceWorker.workerRegistrationUpdated", listener, WorkerRegistrationUpdatedEvent.class);
  }

  public Disposable onWorkerVersionUpdated(Consumer<WorkerVersionUpdatedEvent> listener) {
    return session.subscribe("ServiceWorker.workerVersionUpdated", listener, WorkerVersionUpdatedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeliverPushMessageRequest {
    private final String origin;

    private final RegistrationID registrationId;

    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DispatchSyncEventRequest {
    private final String origin;

    private final RegistrationID registrationId;

    private final String tag;

    private final Boolean lastChance;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DispatchPeriodicSyncEventRequest {
    private final String origin;

    private final RegistrationID registrationId;

    private final String tag;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class InspectWorkerRequest {
    private final String versionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetForceUpdateOnPageLoadRequest {
    private final Boolean forceUpdateOnPageLoad;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SkipWaitingRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartWorkerRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StopWorkerRequest {
    private final String versionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UnregisterRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UpdateRegistrationRequest {
    private final String scopeURL;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class WorkerErrorReportedEvent {
    private final ServiceWorkerErrorMessage errorMessage;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class WorkerRegistrationUpdatedEvent {
    private final List<ServiceWorkerRegistration> registrations;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class WorkerVersionUpdatedEvent {
    private final List<ServiceWorkerVersion> versions;
  }
}
