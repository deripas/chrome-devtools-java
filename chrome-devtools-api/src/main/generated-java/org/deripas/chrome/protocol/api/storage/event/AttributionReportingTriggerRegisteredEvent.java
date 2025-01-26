package org.deripas.chrome.protocol.api.storage.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.storage.AttributionReportingAggregatableResult;
import org.deripas.chrome.protocol.api.storage.AttributionReportingEventLevelResult;
import org.deripas.chrome.protocol.api.storage.AttributionReportingTriggerRegistration;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class AttributionReportingTriggerRegisteredEvent {
  public static final EventId<AttributionReportingTriggerRegisteredEvent> ID = new EventId<>("Storage.attributionReportingTriggerRegistered", AttributionReportingTriggerRegisteredEvent.class);

  private final AttributionReportingTriggerRegistration registration;

  private final AttributionReportingEventLevelResult eventLevel;

  private final AttributionReportingAggregatableResult aggregatable;
}
