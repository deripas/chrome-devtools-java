package org.deripas.chrome.protocol.api.overlay;

import java.lang.Boolean;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Configuration for Window Controls Overlay
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WindowControlsOverlayConfig {
  /**
   * Whether the title bar CSS should be shown when emulating the Window Controls Overlay.
   */
  private final Boolean showCSS;

  /**
   * Selected platforms to show the overlay.
   */
  private final String selectedPlatform;

  /**
   * The theme color defined in app manifest.
   */
  private final String themeColor;
}
