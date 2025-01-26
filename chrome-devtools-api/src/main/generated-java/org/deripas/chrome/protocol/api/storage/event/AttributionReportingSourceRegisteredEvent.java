package org.deripas.chrome.protocol.api.storage.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.storage.AttributionReportingSourceRegistration;
import org.deripas.chrome.protocol.api.storage.AttributionReportingSourceRegistrationResult;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class AttributionReportingSourceRegisteredEvent {
  public static final EventId<AttributionReportingSourceRegisteredEvent> ID = new EventId<>("Storage.attributionReportingSourceRegistered", AttributionReportingSourceRegisteredEvent.class);

  private final AttributionReportingSourceRegistration registration;

  private final AttributionReportingSourceRegistrationResult result;
}
