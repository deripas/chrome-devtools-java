package io.github.deripas.chrome.devtools.api.css;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about font variation axes for variable fonts
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FontVariationAxis {
  /**
   * The font-variation-setting tag (a.k.a. "axis tag").
   */
  private final String tag;

  /**
   * Human-readable variation name in the default language (normally, "en").
   */
  private final String name;

  /**
   * The minimum value (inclusive) the font supports for this tag.
   */
  private final Double minValue;

  /**
   * The maximum value (inclusive) the font supports for this tag.
   */
  private final Double maxValue;

  /**
   * The default value.
   */
  private final Double defaultValue;
}
