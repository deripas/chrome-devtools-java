package org.deripas.chrome.protocol.api.css;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Inherited CSS rule collection from ancestor node.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InheritedStyleEntry {
  /**
   * The ancestor node's inline style, if any, in the style inheritance chain.
   */
  @Nullable
  private final CSSStyle inlineStyle;

  /**
   * Matches of CSS rules matching the ancestor node in the style inheritance chain.
   */
  private final List<RuleMatch> matchedCSSRules;
}
