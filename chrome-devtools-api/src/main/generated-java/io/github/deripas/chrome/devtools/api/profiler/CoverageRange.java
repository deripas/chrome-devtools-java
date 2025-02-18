package io.github.deripas.chrome.devtools.api.profiler;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Coverage data for a source range.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CoverageRange {
  /**
   * JavaScript script source offset for the range start.
   */
  private final Integer startOffset;

  /**
   * JavaScript script source offset for the range end.
   */
  private final Integer endOffset;

  /**
   * Collected execution count of the source range.
   */
  private final Integer count;
}
