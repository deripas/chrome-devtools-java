package org.deripas.chrome.protocol.api.serviceworker.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.serviceworker.ServiceWorkerErrorMessage;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class WorkerErrorReportedEvent {
  public static final EventId<WorkerErrorReportedEvent> ID = new EventId<>("ServiceWorker.workerErrorReported", WorkerErrorReportedEvent.class);

  private final ServiceWorkerErrorMessage errorMessage;
}
