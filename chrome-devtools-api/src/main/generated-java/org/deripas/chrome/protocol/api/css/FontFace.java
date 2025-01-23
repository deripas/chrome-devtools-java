package org.deripas.chrome.protocol.api.css;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 * and additional information such as platformFontFamily and fontVariationAxes.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FontFace {
  /**
   * The font-family.
   */
  private final String fontFamily;

  /**
   * The font-style.
   */
  private final String fontStyle;

  /**
   * The font-variant.
   */
  private final String fontVariant;

  /**
   * The font-weight.
   */
  private final String fontWeight;

  /**
   * The font-stretch.
   */
  private final String fontStretch;

  /**
   * The font-display.
   */
  private final String fontDisplay;

  /**
   * The unicode-range.
   */
  private final String unicodeRange;

  /**
   * The src.
   */
  private final String src;

  /**
   * The resolved platform font family
   */
  private final String platformFontFamily;

  /**
   * Available variation settings (a.k.a. "axes").
   */
  @Nullable
  private final List<FontVariationAxis> fontVariationAxes;
}
