package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.ReportingApiReport;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ReportingApiReportUpdatedEvent {
  public static final EventId<ReportingApiReportUpdatedEvent> ID = new EventId<>("Network.reportingApiReportUpdated", ReportingApiReportUpdatedEvent.class);

  private final ReportingApiReport report;
}
