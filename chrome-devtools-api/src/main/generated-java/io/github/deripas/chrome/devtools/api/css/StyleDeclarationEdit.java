package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A descriptor of operation to mutate style declaration text.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StyleDeclarationEdit {
  /**
   * The css style sheet identifier.
   */
  private final StyleSheetId styleSheetId;

  /**
   * The range of the style text in the enclosing stylesheet.
   */
  private final SourceRange range;

  /**
   * New style text.
   */
  private final String text;
}
