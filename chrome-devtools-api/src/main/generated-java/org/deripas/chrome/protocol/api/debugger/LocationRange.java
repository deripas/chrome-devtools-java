package org.deripas.chrome.protocol.api.debugger;

import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.ScriptId;

/**
 * Location range within one script.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class LocationRange {
  private final ScriptId scriptId;

  private final ScriptPosition start;

  private final ScriptPosition end;
}
