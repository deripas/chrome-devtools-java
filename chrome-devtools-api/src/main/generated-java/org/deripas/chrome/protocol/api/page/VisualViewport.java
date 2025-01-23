package org.deripas.chrome.protocol.api.page;

import java.lang.Long;
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
  private final Long offsetX;

  /**
   * Vertical offset relative to the layout viewport (CSS pixels).
   */
  private final Long offsetY;

  /**
   * Horizontal offset relative to the document (CSS pixels).
   */
  private final Long pageX;

  /**
   * Vertical offset relative to the document (CSS pixels).
   */
  private final Long pageY;

  /**
   * Width (CSS pixels), excludes scrollbar if present.
   */
  private final Long clientWidth;

  /**
   * Height (CSS pixels), excludes scrollbar if present.
   */
  private final Long clientHeight;

  /**
   * Scale relative to the ideal viewport (size at width=device-width).
   */
  private final Long scale;

  /**
   * Page zoom factor (CSS to device independent pixels ratio).
   */
  @Nullable
  private final Long zoom;
}
