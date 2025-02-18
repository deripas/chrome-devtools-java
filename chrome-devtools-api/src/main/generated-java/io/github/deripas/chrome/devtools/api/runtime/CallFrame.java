package io.github.deripas.chrome.devtools.api.runtime;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Stack entry for runtime errors and assertions.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CallFrame {
  /**
   * JavaScript function name.
   */
  private final String functionName;

  /**
   * JavaScript script id.
   */
  private final ScriptId scriptId;

  /**
   * JavaScript script name or url.
   */
  private final String url;

  /**
   * JavaScript script line number (0-based).
   */
  private final Integer lineNumber;

  /**
   * JavaScript script column number (0-based).
   */
  private final Integer columnNumber;
}
