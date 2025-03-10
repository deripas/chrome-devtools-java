package io.github.deripas.chrome.devtools.api.css;

import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Media query expression descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class MediaQueryExpression {
  /**
   * Media query expression value.
   */
  private final Double value;

  /**
   * Media query expression units.
   */
  private final String unit;

  /**
   * Media query expression feature.
   */
  private final String feature;

  /**
   * The associated range of the value text in the enclosing stylesheet (if available).
   */
  @Nullable
  private final SourceRange valueRange;

  /**
   * Computed length of media query expression (if applicable).
   */
  @Nullable
  private final Double computedLength;
}
