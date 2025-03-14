package io.github.deripas.chrome.devtools.api.css;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS function at-rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSFunctionRule {
  /**
   * Name of the function.
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
   * List of parameters.
   */
  private final List<CSSFunctionParameter> parameters;

  /**
   * Function body.
   */
  private final List<CSSFunctionNode> children;
}
