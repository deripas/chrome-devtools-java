package io.github.deripas.chrome.devtools.api.css;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Text range within a resource. All numbers are zero-based.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SourceRange {
  /**
   * Start line of range.
   */
  private final Integer startLine;

  /**
   * Start column of range (inclusive).
   */
  private final Integer startColumn;

  /**
   * End line of range
   */
  private final Integer endLine;

  /**
   * End column of range (exclusive).
   */
  private final Integer endColumn;
}
