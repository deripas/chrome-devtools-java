package org.deripas.chrome.protocol.api.audits;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContentSecurityPolicyIssueDetails {
  /**
   * The url not included in allowed sources.
   */
  @Nullable
  private final String blockedURL;

  /**
   * Specific directive that is violated, causing the CSP issue.
   */
  private final String violatedDirective;

  private final Boolean isReportOnly;

  private final ContentSecurityPolicyViolationType contentSecurityPolicyViolationType;

  @Nullable
  private final AffectedFrame frameAncestor;

  @Nullable
  private final SourceCodeLocation sourceCodeLocation;

  @Nullable
  private final BackendNodeId violatingNodeId;
}
