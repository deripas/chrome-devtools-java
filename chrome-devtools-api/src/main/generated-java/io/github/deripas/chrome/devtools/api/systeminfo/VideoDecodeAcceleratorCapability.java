package io.github.deripas.chrome.devtools.api.systeminfo;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Describes a supported video decoding profile with its associated minimum and
 * maximum resolutions.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class VideoDecodeAcceleratorCapability {
  /**
   * Video codec profile that is supported, e.g. VP9 Profile 2.
   */
  private final String profile;

  /**
   * Maximum video dimensions in pixels supported for this |profile|.
   */
  private final Size maxResolution;

  /**
   * Minimum video dimensions in pixels supported for this |profile|.
   */
  private final Size minResolution;
}
