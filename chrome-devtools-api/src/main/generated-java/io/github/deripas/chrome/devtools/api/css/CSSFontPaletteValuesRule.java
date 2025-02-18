package io.github.deripas.chrome.devtools.api.css;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS font-palette-values rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSFontPaletteValuesRule {
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified
   * stylesheet rules) this rule came from.
   */
  @Nullable
  private final StyleSheetId styleSheetId;

  /**
   * Parent stylesheet's origin.
   */
  private final StyleSheetOrigin origin;

  /**
   * Associated font palette name.
   */
  private final Value fontPaletteName;

  /**
   * Associated style declaration.
   */
  private final CSSStyle style;
}
