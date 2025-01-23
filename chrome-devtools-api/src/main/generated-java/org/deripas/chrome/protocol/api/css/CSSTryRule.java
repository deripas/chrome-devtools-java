package org.deripas.chrome.protocol.api.css;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS try rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSTryRule {
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
   * Associated style declaration.
   */
  private final CSSStyle style;
}
