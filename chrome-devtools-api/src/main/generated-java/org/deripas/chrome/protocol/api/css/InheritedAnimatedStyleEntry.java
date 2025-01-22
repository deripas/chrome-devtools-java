package org.deripas.chrome.protocol.api.css;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Inherited CSS style collection for animated styles from ancestor node.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InheritedAnimatedStyleEntry {
  /**
   * Styles coming from the animations of the ancestor, if any, in the style inheritance chain.
   */
  @Nullable
  private final List<CSSAnimationStyle> animationStyles;

  /**
   * The style coming from the transitions of the ancestor, if any, in the style inheritance chain.
   */
  @Nullable
  private final CSSStyle transitionsStyle;
}
