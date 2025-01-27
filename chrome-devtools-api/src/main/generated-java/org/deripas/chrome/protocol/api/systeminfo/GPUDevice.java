package org.deripas.chrome.protocol.api.systeminfo;

import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Describes a single graphics processor (GPU).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class GPUDevice {
  /**
   * PCI ID of the GPU vendor, if available; 0 otherwise.
   */
  private final Double vendorId;

  /**
   * PCI ID of the GPU device, if available; 0 otherwise.
   */
  private final Double deviceId;

  /**
   * Sub sys ID of the GPU, only available on Windows.
   */
  @Nullable
  private final Double subSysId;

  /**
   * Revision of the GPU, only available on Windows.
   */
  @Nullable
  private final Double revision;

  /**
   * String description of the GPU vendor, if the PCI ID is not available.
   */
  private final String vendorString;

  /**
   * String description of the GPU device, if the PCI ID is not available.
   */
  private final String deviceString;

  /**
   * String description of the GPU driver vendor.
   */
  private final String driverVendor;

  /**
   * String description of the GPU driver version.
   */
  private final String driverVersion;
}
