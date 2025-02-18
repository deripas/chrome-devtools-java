package io.github.deripas.chrome.devtools.api.profiler;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Specifies a number of samples attributed to a certain source position.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PositionTickInfo {
  /**
   * Source line number (1-based).
   */
  private final Integer line;

  /**
   * Number of samples attributed to the source line.
   */
  private final Integer ticks;
}
