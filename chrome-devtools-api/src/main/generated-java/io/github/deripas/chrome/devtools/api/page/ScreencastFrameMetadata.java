package io.github.deripas.chrome.devtools.api.page;

import java.lang.Double;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;

/**
 * Screencast frame metadata.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ScreencastFrameMetadata {
  /**
   * Top offset in DIP.
   */
  private final Double offsetTop;

  /**
   * Page scale factor.
   */
  private final Double pageScaleFactor;

  /**
   * Device screen width in DIP.
   */
  private final Double deviceWidth;

  /**
   * Device screen height in DIP.
   */
  private final Double deviceHeight;

  /**
   * Position of horizontal scroll in CSS pixels.
   */
  private final Double scrollOffsetX;

  /**
   * Position of vertical scroll in CSS pixels.
   */
  private final Double scrollOffsetY;

  /**
   * Frame swap timestamp.
   */
  @Nullable
  private final TimeSinceEpoch timestamp;
}
