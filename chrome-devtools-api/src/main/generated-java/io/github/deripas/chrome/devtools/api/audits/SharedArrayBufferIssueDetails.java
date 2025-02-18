package io.github.deripas.chrome.devtools.api.audits;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Details for a issue arising from an SAB being instantiated in, or
 * transferred to a context that is not cross-origin isolated.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedArrayBufferIssueDetails {
  private final SourceCodeLocation sourceCodeLocation;

  private final Boolean isWarning;

  private final SharedArrayBufferIssueType type;
}
