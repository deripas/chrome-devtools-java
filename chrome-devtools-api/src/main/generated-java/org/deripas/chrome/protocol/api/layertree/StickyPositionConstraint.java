package org.deripas.chrome.protocol.api.layertree;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.Rect;

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
