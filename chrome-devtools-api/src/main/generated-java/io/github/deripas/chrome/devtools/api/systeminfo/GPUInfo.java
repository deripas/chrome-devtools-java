package io.github.deripas.chrome.devtools.api.systeminfo;

import java.lang.String;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Provides information about the GPU(s) on the system.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class GPUInfo {
  /**
   * The graphics devices on the system. Element 0 is the primary GPU.
   */
  private final List<GPUDevice> devices;

  /**
   * An optional dictionary of additional GPU related attributes.
   */
  @Nullable
  private final Map auxAttributes;

  /**
   * An optional dictionary of graphics features and their status.
   */
  @Nullable
  private final Map featureStatus;

  /**
   * An optional array of GPU driver bug workarounds.
   */
  private final List<String> driverBugWorkarounds;

  /**
   * Supported accelerated video decoding capabilities.
   */
  private final List<VideoDecodeAcceleratorCapability> videoDecoding;

  /**
   * Supported accelerated video encoding capabilities.
   */
  private final List<VideoEncodeAcceleratorCapability> videoEncoding;

  /**
   * Supported accelerated image decoding capabilities.
   */
  private final List<ImageDecodeAcceleratorCapability> imageDecoding;
}
