package io.github.deripas.chrome.devtools.api.overlay;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Configuration data for the highlighting of Flex item elements.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FlexItemHighlightConfig {
  /**
   * Style of the box representing the item's base size
   */
  @Nullable
  private final BoxStyle baseSizeBox;

  /**
   * Style of the border around the box representing the item's base size
   */
  @Nullable
  private final LineStyle baseSizeBorder;

  /**
   * Style of the arrow representing if the item grew or shrank
   */
  @Nullable
  private final LineStyle flexibilityArrow;
}
