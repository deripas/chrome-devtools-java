package org.deripas.chrome.protocol.api.systeminfo;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Describes a supported image decoding profile with its associated minimum and
 * maximum resolutions and subsampling.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ImageDecodeAcceleratorCapability {
  /**
   * Image coded, e.g. Jpeg.
   */
  private final ImageType imageType;

  /**
   * Maximum supported dimensions of the image in pixels.
   */
  private final Size maxDimensions;

  /**
   * Minimum supported dimensions of the image in pixels.
   */
  private final Size minDimensions;

  /**
   * Optional array of supported subsampling formats, e.g. 4:2:0, if known.
   */
  private final List<SubsamplingFormat> subsamplings;
}
