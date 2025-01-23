package org.deripas.chrome.protocol.api.overlay;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Configuration data for the highlighting of Flex container elements.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FlexContainerHighlightConfig {
  /**
   * The style of the container border
   */
  @Nullable
  private final LineStyle containerBorder;

  /**
   * The style of the separator between lines
   */
  @Nullable
  private final LineStyle lineSeparator;

  /**
   * The style of the separator between items
   */
  @Nullable
  private final LineStyle itemSeparator;

  /**
   * Style of content-distribution space on the main axis (justify-content).
   */
  @Nullable
  private final BoxStyle mainDistributedSpace;

  /**
   * Style of content-distribution space on the cross axis (align-content).
   */
  @Nullable
  private final BoxStyle crossDistributedSpace;

  /**
   * Style of empty space caused by row gaps (gap/row-gap).
   */
  @Nullable
  private final BoxStyle rowGapSpace;

  /**
   * Style of empty space caused by columns gaps (gap/column-gap).
   */
  @Nullable
  private final BoxStyle columnGapSpace;

  /**
   * Style of the self-alignment line (align-items).
   */
  @Nullable
  private final LineStyle crossAlignment;
}
