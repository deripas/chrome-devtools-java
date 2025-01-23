package org.deripas.chrome.protocol.api.browser;

import java.lang.Integer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Browser window bounds information
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class Bounds {
  /**
   * The offset from the left edge of the screen to the window in pixels.
   */
  @Nullable
  private final Integer left;

  /**
   * The offset from the top edge of the screen to the window in pixels.
   */
  @Nullable
  private final Integer top;

  /**
   * The window width in pixels.
   */
  @Nullable
  private final Integer width;

  /**
   * The window height in pixels.
   */
  @Nullable
  private final Integer height;

  /**
   * The window state. Default to normal.
   */
  @Nullable
  private final WindowState windowState;
}
