package org.deripas.chrome.protocol.api.overlay;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.RGBA;

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
