package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.ReportingApiEndpoint;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ReportingApiEndpointsChangedForOriginEvent {
  public static final EventId<ReportingApiEndpointsChangedForOriginEvent> ID = new EventId<>("Network.reportingApiEndpointsChangedForOrigin", ReportingApiEndpointsChangedForOriginEvent.class);

  /**
   * Origin of the document(s) which configured the endpoints.
   */
  private final String origin;

  private final List<ReportingApiEndpoint> endpoints;
}
