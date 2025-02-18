package io.github.deripas.chrome.devtools.api.debugger;

import io.github.deripas.chrome.devtools.api.runtime.ScriptId;
import java.lang.Integer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Location in the source code.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Location {
  /**
   * Script identifier as reported in the `Debugger.scriptParsed`.
   */
  private final ScriptId scriptId;

  /**
   * Line number in the script (0-based).
   */
  private final Integer lineNumber;

  /**
   * Column number in the script (0-based).
   */
  @Nullable
  private final Integer columnNumber;
}
