package org.deripas.chrome.protocol.api.audits;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class HeavyAdIssueDetails {
  /**
   * The resolution status, either blocking the content or warning.
   */
  private final HeavyAdResolutionStatus resolution;

  /**
   * The reason the ad was blocked, total network or cpu or peak cpu.
   */
  private final HeavyAdReason reason;

  /**
   * The frame that was blocked.
   */
  private final AffectedFrame frame;
}
