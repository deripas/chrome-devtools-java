package io.github.deripas.chrome.devtools.api.profiler;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Coverage data for a JavaScript function.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FunctionCoverage {
  /**
   * JavaScript function name.
   */
  private final String functionName;

  /**
   * Source ranges inside the function with coverage data.
   */
  private final List<CoverageRange> ranges;

  /**
   * Whether coverage data for this function has block granularity.
   */
  private final Boolean isBlockCoverage;
}
