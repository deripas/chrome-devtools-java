package org.deripas.chrome.protocol.api.deviceorientation;

import java.lang.Long;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface DeviceOrientation {
  /**
   * Clears the overridden Device Orientation.
   */
  void clearDeviceOrientationOverride();

  /**
   * Overrides the Device Orientation.
   */
  void setDeviceOrientationOverride(SetDeviceOrientationOverrideRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDeviceOrientationOverrideRequest {
    /**
     * Mock alpha
     */
    private final Long alpha;

    /**
     * Mock beta
     */
    private final Long beta;

    /**
     * Mock gamma
     */
    private final Long gamma;
  }
}
