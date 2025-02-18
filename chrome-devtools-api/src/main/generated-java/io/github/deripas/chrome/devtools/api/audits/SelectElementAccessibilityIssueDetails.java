package io.github.deripas.chrome.devtools.api.audits;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue warns about errors in the select element content model.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SelectElementAccessibilityIssueDetails {
  private final BackendNodeId nodeId;

  private final SelectElementAccessibilityIssueReason selectElementAccessibilityIssueReason;

  private final Boolean hasDisallowedAttributes;
}
