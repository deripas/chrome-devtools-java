package io.github.deripas.chrome.devtools.api.audits;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class LowTextContrastIssueDetails {
  private final BackendNodeId violatingNodeId;

  private final String violatingNodeSelector;

  private final Double contrastRatio;

  private final Double thresholdAA;

  private final Double thresholdAAA;

  private final String fontSize;

  private final String fontWeight;
}
