package io.github.deripas.chrome.devtools.api.css;

import java.lang.Integer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Specificity:
 * https://drafts.csswg.org/selectors/#specificity-rules
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class Specificity {
  /**
   * The a component, which represents the number of ID selectors.
   */
  private final Integer a;

  /**
   * The b component, which represents the number of class selectors, attributes selectors, and
   * pseudo-classes.
   */
  private final Integer b;

  /**
   * The c component, which represents the number of type selectors and pseudo-elements.
   */
  private final Integer c;
}
