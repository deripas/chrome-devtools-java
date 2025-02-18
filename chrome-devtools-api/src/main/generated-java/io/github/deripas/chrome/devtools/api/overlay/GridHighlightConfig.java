package io.github.deripas.chrome.devtools.api.overlay;

import java.lang.Boolean;
import java.lang.Deprecated;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.RGBA;

/**
 * Configuration data for the highlighting of Grid elements.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class GridHighlightConfig {
  /**
   * Whether the extension lines from grid cells to the rulers should be shown (default: false).
   */
  @Nullable
  private final Boolean showGridExtensionLines;

  /**
   * Show Positive line number labels (default: false).
   */
  @Nullable
  private final Boolean showPositiveLineNumbers;

  /**
   * Show Negative line number labels (default: false).
   */
  @Nullable
  private final Boolean showNegativeLineNumbers;

  /**
   * Show area name labels (default: false).
   */
  @Nullable
  private final Boolean showAreaNames;

  /**
   * Show line name labels (default: false).
   */
  @Nullable
  private final Boolean showLineNames;

  /**
   * Show track size labels (default: false).
   */
  @Nullable
  private final Boolean showTrackSizes;

  /**
   * The grid container border highlight color (default: transparent).
   */
  @Nullable
  private final RGBA gridBorderColor;

  /**
   * The cell border color (default: transparent). Deprecated, please use rowLineColor and columnLineColor instead.
   */
  @Nullable
  @Deprecated
  private final RGBA cellBorderColor;

  /**
   * The row line color (default: transparent).
   */
  @Nullable
  private final RGBA rowLineColor;

  /**
   * The column line color (default: transparent).
   */
  @Nullable
  private final RGBA columnLineColor;

  /**
   * Whether the grid border is dashed (default: false).
   */
  @Nullable
  private final Boolean gridBorderDash;

  /**
   * Whether the cell border is dashed (default: false). Deprecated, please us rowLineDash and columnLineDash instead.
   */
  @Nullable
  @Deprecated
  private final Boolean cellBorderDash;

  /**
   * Whether row lines are dashed (default: false).
   */
  @Nullable
  private final Boolean rowLineDash;

  /**
   * Whether column lines are dashed (default: false).
   */
  @Nullable
  private final Boolean columnLineDash;

  /**
   * The row gap highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA rowGapColor;

  /**
   * The row gap hatching fill color (default: transparent).
   */
  @Nullable
  private final RGBA rowHatchColor;

  /**
   * The column gap highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA columnGapColor;

  /**
   * The column gap hatching fill color (default: transparent).
   */
  @Nullable
  private final RGBA columnHatchColor;

  /**
   * The named grid areas border color (Default: transparent).
   */
  @Nullable
  private final RGBA areaBorderColor;

  /**
   * The grid container background color (Default: transparent).
   */
  @Nullable
  private final RGBA gridBackgroundColor;
}
