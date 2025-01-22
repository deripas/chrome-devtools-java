package org.deripas.chrome.protocol.api.page;

import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Font families collection for a script.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ScriptFontFamilies {
  /**
   * Name of the script which these font families are defined for.
   */
  private final String script;

  /**
   * Generic font families collection for the script.
   */
  private final FontFamilies fontFamilies;
}
