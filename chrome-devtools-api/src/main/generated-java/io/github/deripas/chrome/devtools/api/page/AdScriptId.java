package io.github.deripas.chrome.devtools.api.page;

import io.github.deripas.chrome.devtools.api.runtime.ScriptId;
import io.github.deripas.chrome.devtools.api.runtime.UniqueDebuggerId;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Identifies the bottom-most script which caused the frame to be labelled
 * as an ad.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AdScriptId {
  /**
   * Script Id of the bottom-most script which caused the frame to be labelled
   * as an ad.
   */
  private final ScriptId scriptId;

  /**
   * Id of adScriptId's debugger.
   */
  private final UniqueDebuggerId debuggerId;
}
