package org.deripas.chrome.protocol.api.css;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS style representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSStyle {
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified
   * stylesheet rules) this rule came from.
   */
  @Nullable
  private final StyleSheetId styleSheetId;

  /**
   * CSS properties in the style.
   */
  private final List<CSSProperty> cssProperties;

  /**
   * Computed values for all shorthands found in the style.
   */
  private final List<ShorthandEntry> shorthandEntries;

  /**
   * Style declaration text (if available).
   */
  @Nullable
  private final String cssText;

  /**
   * Style declaration range in the enclosing stylesheet (if available).
   */
  @Nullable
  private final SourceRange range;
}
