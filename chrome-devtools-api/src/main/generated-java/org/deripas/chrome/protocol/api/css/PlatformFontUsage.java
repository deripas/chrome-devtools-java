package org.deripas.chrome.protocol.api.css;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about amount of glyphs that were rendered with given font.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlatformFontUsage {
  /**
   * Font's family name reported by platform.
   */
  private final String familyName;

  /**
   * Font's PostScript name reported by platform.
   */
  private final String postScriptName;

  /**
   * Indicates if the font was downloaded or resolved locally.
   */
  private final Boolean isCustomFont;

  /**
   * Amount of glyphs that were rendered with this font.
   */
  private final Double glyphCount;
}
