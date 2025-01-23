package org.deripas.chrome.protocol.api.profiler;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.ScriptId;

/**
 * Coverage data for a JavaScript script.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScriptCoverage {
  /**
   * JavaScript script id.
   */
  private final ScriptId scriptId;

  /**
   * JavaScript script name or url.
   */
  private final String url;

  /**
   * Functions contained in the script that has coverage data.
   */
  private final List<FunctionCoverage> functions;
}
