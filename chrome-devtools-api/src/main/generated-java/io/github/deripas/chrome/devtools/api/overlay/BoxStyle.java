package io.github.deripas.chrome.devtools.api.overlay;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.RGBA;

/**
 * Style information for drawing a box.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BoxStyle {
  /**
   * The background color for the box (default: transparent)
   */
  @Nullable
  private final RGBA fillColor;

  /**
   * The hatching color for the box (default: transparent)
   */
  @Nullable
  private final RGBA hatchColor;
}
