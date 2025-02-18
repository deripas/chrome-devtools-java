package io.github.deripas.chrome.devtools.api.css;

import java.lang.Integer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Match data for a CSS rule.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RuleMatch {
  /**
   * CSS rule in the match.
   */
  private final CSSRule rule;

  /**
   * Matching selector indices in the rule's selectorList selectors (0-based).
   */
  private final List<Integer> matchingSelectors;
}
