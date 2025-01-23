package org.deripas.chrome.protocol.api.page;

import java.lang.Long;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

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
  private final Long offsetTop;

  /**
   * Page scale factor.
   */
  private final Long pageScaleFactor;

  /**
   * Device screen width in DIP.
   */
  private final Long deviceWidth;

  /**
   * Device screen height in DIP.
   */
  private final Long deviceHeight;

  /**
   * Position of horizontal scroll in CSS pixels.
   */
  private final Long scrollOffsetX;

  /**
   * Position of vertical scroll in CSS pixels.
   */
  private final Long scrollOffsetY;

  /**
   * Frame swap timestamp.
   */
  @Nullable
  private final TimeSinceEpoch timestamp;
}
