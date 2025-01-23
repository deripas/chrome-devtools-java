package org.deripas.chrome.protocol.api.css;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS property at-rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSPropertyRule {
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
   * Associated property name.
   */
  private final Value propertyName;

  /**
   * Associated style declaration.
   */
  private final CSSStyle style;
}
