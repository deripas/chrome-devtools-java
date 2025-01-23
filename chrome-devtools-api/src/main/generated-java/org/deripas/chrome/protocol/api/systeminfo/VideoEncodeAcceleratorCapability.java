package org.deripas.chrome.protocol.api.systeminfo;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Describes a supported video encoding profile with its associated maximum
 * resolution and maximum framerate.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class VideoEncodeAcceleratorCapability {
  /**
   * Video codec profile that is supported, e.g H264 Main.
   */
  private final String profile;

  /**
   * Maximum video dimensions in pixels supported for this |profile|.
   */
  private final Size maxResolution;

  /**
   * Maximum encoding framerate in frames per second supported for this
   * |profile|, as fraction's numerator and denominator, e.g. 24/1 fps,
   * 24000/1001 fps, etc.
   */
  private final Integer maxFramerateNumerator;

  private final Integer maxFramerateDenominator;
}
