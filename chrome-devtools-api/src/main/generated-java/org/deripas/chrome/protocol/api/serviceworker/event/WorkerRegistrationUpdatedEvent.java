package org.deripas.chrome.protocol.api.serviceworker.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.serviceworker.ServiceWorkerRegistration;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class WorkerRegistrationUpdatedEvent {
  public static final EventId<WorkerRegistrationUpdatedEvent> ID = new EventId<>("ServiceWorker.workerRegistrationUpdated", WorkerRegistrationUpdatedEvent.class);

  private final List<ServiceWorkerRegistration> registrations;
}
