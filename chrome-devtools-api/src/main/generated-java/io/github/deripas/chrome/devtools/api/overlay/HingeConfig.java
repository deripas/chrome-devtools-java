package io.github.deripas.chrome.devtools.api.overlay;

import io.github.deripas.chrome.devtools.api.dom.RGBA;
import io.github.deripas.chrome.devtools.api.dom.Rect;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
