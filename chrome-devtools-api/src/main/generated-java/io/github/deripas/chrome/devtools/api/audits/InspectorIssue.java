package io.github.deripas.chrome.devtools.api.audits;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * An inspector issue reported from the back-end.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InspectorIssue {
  private final InspectorIssueCode code;

  private final InspectorIssueDetails details;

  /**
   * A unique id for this issue. May be omitted if no other entity (e.g.
   * exception, CDP message, etc.) is referencing this issue.
   */
  @Nullable
  private final IssueId issueId;
}
