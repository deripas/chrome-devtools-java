package org.deripas.chrome.protocol.api.css;

import java.lang.Boolean;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS @position-try rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSPositionTryRule {
  /**
   * The prelude dashed-ident name
   */
  private final Value name;

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

  private final Boolean active;
}
