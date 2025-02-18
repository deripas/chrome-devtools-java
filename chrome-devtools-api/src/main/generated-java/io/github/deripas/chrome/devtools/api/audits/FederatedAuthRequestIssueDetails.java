package io.github.deripas.chrome.devtools.api.audits;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class FederatedAuthRequestIssueDetails {
  private final FederatedAuthRequestIssueReason federatedAuthRequestIssueReason;
}
