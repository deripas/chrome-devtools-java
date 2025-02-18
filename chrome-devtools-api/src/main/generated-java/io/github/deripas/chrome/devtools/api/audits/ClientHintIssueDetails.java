package io.github.deripas.chrome.devtools.api.audits;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue tracks client hints related issues. It's used to deprecate old
 * features, encourage the use of new ones, and provide general guidance.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ClientHintIssueDetails {
  private final SourceCodeLocation sourceCodeLocation;

  private final ClientHintIssueReason clientHintIssueReason;
}
