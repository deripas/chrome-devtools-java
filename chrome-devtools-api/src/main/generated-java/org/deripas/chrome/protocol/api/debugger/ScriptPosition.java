package org.deripas.chrome.protocol.api.debugger;

import java.lang.Integer;
import jdk.jfr.Experimental;
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
@Experimental
@Generated
public class ScriptPosition {
  private final Integer lineNumber;

  private final Integer columnNumber;
}
