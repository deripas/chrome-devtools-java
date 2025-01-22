package org.deripas.chrome.protocol.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

/**
 * Details for issues around "Attribution Reporting API" usage.
 * Explainer: https://github.com/WICG/attribution-reporting-api
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AttributionReportingIssueDetails {
  private final AttributionReportingIssueType violationType;

  @Nullable
  private final AffectedRequest request;

  @Nullable
  private final BackendNodeId violatingNodeId;

  @Nullable
  private final String invalidParameter;
}
