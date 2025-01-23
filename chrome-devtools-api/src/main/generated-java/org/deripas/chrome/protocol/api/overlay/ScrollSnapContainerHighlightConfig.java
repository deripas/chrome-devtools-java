package org.deripas.chrome.protocol.api.overlay;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.RGBA;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScrollSnapContainerHighlightConfig {
  /**
   * The style of the snapport border (default: transparent)
   */
  @Nullable
  private final LineStyle snapportBorder;

  /**
   * The style of the snap area border (default: transparent)
   */
  @Nullable
  private final LineStyle snapAreaBorder;

  /**
   * The margin highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA scrollMarginColor;

  /**
   * The padding highlight fill color (default: transparent).
   */
  @Nullable
  private final RGBA scrollPaddingColor;
}
