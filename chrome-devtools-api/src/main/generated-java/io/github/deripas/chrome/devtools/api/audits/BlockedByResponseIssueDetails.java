package io.github.deripas.chrome.devtools.api.audits;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Details for a request that has been blocked with the BLOCKED_BY_RESPONSE
 * code. Currently only used for COEP/COOP, but may be extended to include
 * some CSP errors in the future.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BlockedByResponseIssueDetails {
  private final AffectedRequest request;

  @Nullable
  private final AffectedFrame parentFrame;

  @Nullable
  private final AffectedFrame blockedFrame;

  private final BlockedByResponseReason reason;
}
