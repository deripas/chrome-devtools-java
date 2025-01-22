package org.deripas.chrome.protocol.api.debugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.ScriptId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class BreakLocation {
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

  @Nullable
  private final Type type;

  public enum Type {
    @JsonProperty("debuggerStatement")
    DEBUGGER_STATEMENT,

    @JsonProperty("call")
    CALL,

    @JsonProperty("return")
    RETURN
  }
}
