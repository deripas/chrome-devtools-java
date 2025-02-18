package io.github.deripas.chrome.devtools.api.css;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS Supports at-rule descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CSSSupports {
  /**
   * Supports rule text.
   */
  private final String text;

  /**
   * Whether the supports condition is satisfied.
   */
  private final Boolean active;

  /**
   * The associated rule header range in the enclosing stylesheet (if
   * available).
   */
  @Nullable
  private final SourceRange range;

  /**
   * Identifier of the stylesheet containing this object (if exists).
   */
  @Nullable
  private final StyleSheetId styleSheetId;
}
