package io.github.deripas.chrome.devtools.api.deviceorientation;

import java.lang.Double;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
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
  CompletableFuture<Void> clearDeviceOrientationOverride();

  /**
   * Overrides the Device Orientation.
   */
  CompletableFuture<Void> setDeviceOrientationOverride(SetDeviceOrientationOverrideRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDeviceOrientationOverrideRequest {
    /**
     * Mock alpha
     */
    private final Double alpha;

    /**
     * Mock beta
     */
    private final Double beta;

    /**
     * Mock gamma
     */
    private final Double gamma;
  }
}
