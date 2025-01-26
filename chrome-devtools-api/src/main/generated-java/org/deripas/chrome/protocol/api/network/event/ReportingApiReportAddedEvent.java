package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.ReportingApiReport;

/**
 * Is sent whenever a new report is added.
 * And after 'enableReportingApi' for all existing reports.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ReportingApiReportAddedEvent {
  public static final EventId<ReportingApiReportAddedEvent> ID = new EventId<>("Network.reportingApiReportAdded", ReportingApiReportAddedEvent.class);

  private final ReportingApiReport report;
}
