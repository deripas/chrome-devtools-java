package io.github.deripas.chrome.devtools.api.layertree;

import io.github.deripas.chrome.devtools.api.dom.Rect;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Sticky position constraints.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StickyPositionConstraint {
  /**
   * Layout rectangle of the sticky element before being shifted
   */
  private final Rect stickyBoxRect;

  /**
   * Layout rectangle of the containing block of the sticky element
   */
  private final Rect containingBlockRect;

  /**
   * The nearest sticky layer that shifts the sticky box
   */
  @Nullable
  private final LayerId nearestLayerShiftingStickyBox;

  /**
   * The nearest sticky layer that shifts the containing block
   */
  @Nullable
  private final LayerId nearestLayerShiftingContainingBlock;
}
