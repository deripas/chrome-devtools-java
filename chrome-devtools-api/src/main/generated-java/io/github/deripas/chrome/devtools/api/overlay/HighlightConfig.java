package io.github.deripas.chrome.devtools.api.overlay;

import java.lang.Boolean;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.RGBA;

/**
 * Configuration data for the highlighting of page elements.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class HighlightConfig {
  /**
   * Whether the node info tooltip should be shown (default: false).
   */
  @Nullable
  private final Boolean showInfo;

  /**
   * Whether the node styles in the tooltip (default: false).
   */
  @Nullable
  private final Boolean showStyles;

  /**
   * Whether the rulers should be shown (default: false).
   */
  @Nullable
  private final Boolean showRulers;

  /**
   * Whether the a11y info should be shown (default: true).
   */
  @Nullable
  private final Boolean showAccessibilityInfo;

  /**
   * Whether the extension lines from node to the rulers should be shown (default: false).
   */
  @Nullable
  private final Boolean showExtensionLines;

  /**
   * The content box highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA contentColor;

  /**
   * The padding highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA paddingColor;

  /**
   * The border highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA borderColor;

  /**
   * The margin highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA marginColor;

  /**
   * The event target element highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA eventTargetColor;

  /**
   * The shape outside fill color (default: transparent).
   */
  @Nullable
  private final RGBA shapeColor;

  /**
   * The shape margin fill color (default: transparent).
   */
  @Nullable
  private final RGBA shapeMarginColor;

  /**
   * The grid layout color (default: transparent).
   */
  @Nullable
  private final RGBA cssGridColor;

  /**
   * The color format used to format color styles (default: hex).
   */
  @Nullable
  private final ColorFormat colorFormat;

  /**
   * The grid layout highlight configuration (default: all transparent).
   */
  @Nullable
  private final GridHighlightConfig gridHighlightConfig;

  /**
   * The flex container highlight configuration (default: all transparent).
   */
  @Nullable
  private final FlexContainerHighlightConfig flexContainerHighlightConfig;

  /**
   * The flex item highlight configuration (default: all transparent).
   */
  @Nullable
  private final FlexItemHighlightConfig flexItemHighlightConfig;

  /**
   * The contrast algorithm to use for the contrast ratio (default: aa).
   */
  @Nullable
  private final ContrastAlgorithm contrastAlgorithm;

  /**
   * The container query container highlight configuration (default: all transparent).
   */
  @Nullable
  private final ContainerQueryContainerHighlightConfig containerQueryContainerHighlightConfig;
}
