package io.github.deripas.chrome.devtools.api.css;

import java.lang.Boolean;
import java.lang.Double;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS coverage information.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RuleUsage {
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified
   * stylesheet rules) this rule came from.
   */
  private final StyleSheetId styleSheetId;

  /**
   * Offset of the start of the rule (including selector) from the beginning of the stylesheet.
   */
  private final Double startOffset;

  /**
   * Offset of the end of the rule body from the beginning of the stylesheet.
   */
  private final Double endOffset;

  /**
   * Indicates whether the rule was actually used by some element in the page.
   */
  private final Boolean used;
}
