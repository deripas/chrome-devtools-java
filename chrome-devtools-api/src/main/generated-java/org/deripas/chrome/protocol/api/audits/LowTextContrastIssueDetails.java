package org.deripas.chrome.protocol.api.audits;

import java.lang.Long;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class LowTextContrastIssueDetails {
  private final BackendNodeId violatingNodeId;

  private final String violatingNodeSelector;

  private final Long contrastRatio;

  private final Long thresholdAA;

  private final Long thresholdAAA;

  private final String fontSize;

  private final String fontWeight;
}
