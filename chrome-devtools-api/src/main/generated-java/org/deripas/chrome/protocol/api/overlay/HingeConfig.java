package org.deripas.chrome.protocol.api.overlay;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.RGBA;
import org.deripas.chrome.protocol.api.dom.Rect;

/**
 * Configuration for dual screen hinge
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class HingeConfig {
  /**
   * A rectangle represent hinge
   */
  private final Rect rect;

  /**
   * The content box highlight fill color (default: a dark color).
   */
  @Nullable
  private final RGBA contentColor;

  /**
   * The content box highlight outline color (default: transparent).
   */
  @Nullable
  private final RGBA outlineColor;
}
