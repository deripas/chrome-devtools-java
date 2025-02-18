package io.github.deripas.chrome.devtools.api.debugger;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ResolvedBreakpoint {
  /**
   * Breakpoint unique identifier.
   */
  private final BreakpointId breakpointId;

  /**
   * Actual breakpoint location.
   */
  private final Location location;
}
