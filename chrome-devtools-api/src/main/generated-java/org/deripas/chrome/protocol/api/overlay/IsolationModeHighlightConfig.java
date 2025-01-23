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
public class IsolationModeHighlightConfig {
  /**
   * The fill color of the resizers (default: transparent).
   */
  @Nullable
  private final RGBA resizerColor;

  /**
   * The fill color for resizer handles (default: transparent).
   */
  @Nullable
  private final RGBA resizerHandleColor;

  /**
   * The fill color for the mask covering non-isolated elements (default: transparent).
   */
  @Nullable
  private final RGBA maskColor;
}
