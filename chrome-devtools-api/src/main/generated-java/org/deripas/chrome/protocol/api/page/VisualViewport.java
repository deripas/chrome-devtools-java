package org.deripas.chrome.protocol.api.page;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Visual viewport position, dimensions, and scale.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class VisualViewport {
  /**
   * Horizontal offset relative to the layout viewport (CSS pixels).
   */
  private final Double offsetX;

  /**
   * Vertical offset relative to the layout viewport (CSS pixels).
   */
  private final Double offsetY;

  /**
   * Horizontal offset relative to the document (CSS pixels).
   */
  private final Double pageX;

  /**
   * Vertical offset relative to the document (CSS pixels).
   */
  private final Double pageY;

  /**
   * Width (CSS pixels), excludes scrollbar if present.
   */
  private final Double clientWidth;

  /**
   * Height (CSS pixels), excludes scrollbar if present.
   */
  private final Double clientHeight;

  /**
   * Scale relative to the ideal viewport (size at width=device-width).
   */
  private final Double scale;

  /**
   * Page zoom factor (CSS to device independent pixels ratio).
   */
  @Nullable
  private final Double zoom;
}
