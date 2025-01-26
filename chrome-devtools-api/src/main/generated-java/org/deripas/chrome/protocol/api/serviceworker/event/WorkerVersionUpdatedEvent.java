package org.deripas.chrome.protocol.api.serviceworker.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.serviceworker.ServiceWorkerVersion;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class WorkerVersionUpdatedEvent {
  public static final EventId<WorkerVersionUpdatedEvent> ID = new EventId<>("ServiceWorker.workerVersionUpdated", WorkerVersionUpdatedEvent.class);

  private final List<ServiceWorkerVersion> versions;
}
