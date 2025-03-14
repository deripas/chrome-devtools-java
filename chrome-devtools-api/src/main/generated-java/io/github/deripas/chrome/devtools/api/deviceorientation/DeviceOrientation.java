package io.github.deripas.chrome.devtools.api.deviceorientation;

import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Double;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class DeviceOrientation {
  private final Session session;

  /**
   * Clears the overridden Device Orientation.
   */
  public CompletableFuture<Void> clearDeviceOrientationOverride() {
    return session.send("DeviceOrientation.clearDeviceOrientationOverride", null, Void.class);
  }

  /**
   * Overrides the Device Orientation.
   */
  public CompletableFuture<Void> setDeviceOrientationOverride(
      SetDeviceOrientationOverrideRequest request) {
    return session.send("DeviceOrientation.setDeviceOrientationOverride", request, Void.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDeviceOrientationOverrideRequest {
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
