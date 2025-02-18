package io.github.deripas.chrome.devtools.api.debugger;

import io.github.deripas.chrome.devtools.api.runtime.ScriptId;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
