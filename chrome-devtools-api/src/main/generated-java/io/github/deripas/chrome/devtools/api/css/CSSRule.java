package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSRule {
  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified
   * stylesheet rules) this rule came from.
   */
  @Nullable
  private final StyleSheetId styleSheetId;

  /**
   * Rule selector data.
   */
  private final SelectorList selectorList;

  /**
   * Array of selectors from ancestor style rules, sorted by distance from the current rule.
   */
  @Nullable
  @Experimental
  private final List<String> nestingSelectors;

  /**
   * Parent stylesheet's origin.
   */
  private final StyleSheetOrigin origin;

  /**
   * Associated style declaration.
   */
  private final CSSStyle style;

  /**
   * Media list array (for rules involving media queries). The array enumerates media queries
   * starting with the innermost one, going outwards.
   */
  @Nullable
  private final List<CSSMedia> media;

  /**
   * Container query list array (for rules involving container queries).
   * The array enumerates container queries starting with the innermost one, going outwards.
   */
  @Nullable
  @Experimental
  private final List<CSSContainerQuery> containerQueries;

  /**
   * &commat;supports CSS at-rule array.
   * The array enumerates &commat;supports at-rules starting with the innermost one, going outwards.
   */
  @Nullable
  @Experimental
  private final List<CSSSupports> supports;

  /**
   * Cascade layer array. Contains the layer hierarchy that this rule belongs to starting
   * with the innermost layer and going outwards.
   */
  @Nullable
  @Experimental
  private final List<CSSLayer> layers;

  /**
   * &commat;scope CSS at-rule array.
   * The array enumerates &commat;scope at-rules starting with the innermost one, going outwards.
   */
  @Nullable
  @Experimental
  private final List<CSSScope> scopes;

  /**
   * The array keeps the types of ancestor CSSRules from the innermost going outwards.
   */
  @Nullable
  @Experimental
  private final List<CSSRuleType> ruleTypes;

  /**
   * &commat;starting-style CSS at-rule array.
   * The array enumerates &commat;starting-style at-rules starting with the innermost one, going outwards.
   */
  @Nullable
  @Experimental
  private final List<CSSStartingStyle> startingStyles;
}
