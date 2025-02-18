package io.github.deripas.chrome.devtools.api.page;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Layout viewport position and dimensions.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayoutViewport {
  /**
   * Horizontal offset relative to the document (CSS pixels).
   */
  private final Integer pageX;

  /**
   * Vertical offset relative to the document (CSS pixels).
   */
  private final Integer pageY;

  /**
   * Width (CSS pixels), excludes scrollbar if present.
   */
  private final Integer clientWidth;

  /**
   * Height (CSS pixels), excludes scrollbar if present.
   */
  private final Integer clientHeight;
}
