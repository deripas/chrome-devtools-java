package org.deripas.chrome.protocol.api.audits;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

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
