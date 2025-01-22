package org.deripas.chrome.protocol.api.audits;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class FederatedAuthUserInfoRequestIssueDetails {
  private final FederatedAuthUserInfoRequestIssueReason federatedAuthUserInfoRequestIssueReason;
}
