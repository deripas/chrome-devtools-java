package io.github.deripas.chrome.devtools.api.overlay;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.RGBA;

/**
 * Configuration data for drawing the source order of an elements children.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SourceOrderConfig {
  /**
   * the color to outline the given element in.
   */
  private final RGBA parentOutlineColor;

  /**
   * the color to outline the child elements in.
   */
  private final RGBA childOutlineColor;
}
