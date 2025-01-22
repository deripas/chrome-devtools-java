package org.deripas.chrome.protocol.api.serviceworker;

import java.lang.Boolean;
import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface ServiceWorker {
  void deliverPushMessage(DeliverPushMessageRequest request);

  void disable();

  void dispatchSyncEvent(DispatchSyncEventRequest request);

  void dispatchPeriodicSyncEvent(DispatchPeriodicSyncEventRequest request);

  void enable();

  void inspectWorker(InspectWorkerRequest request);

  void setForceUpdateOnPageLoad(SetForceUpdateOnPageLoadRequest request);

  void skipWaiting(SkipWaitingRequest request);

  void startWorker(StartWorkerRequest request);

  void stopAllWorkers();

  void stopWorker(StopWorkerRequest request);

  void unregister(UnregisterRequest request);

  void updateRegistration(UpdateRegistrationRequest request);

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
}
