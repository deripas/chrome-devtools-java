package io.github.deripas.chrome.devtools.api.input;

import java.lang.Double;
import java.lang.Integer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class TouchPoint {
  /**
   * X coordinate of the event relative to the main frame's viewport in CSS pixels.
   */
  private final Double x;

  /**
   * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to
   * the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
   */
  private final Double y;

  /**
   * X radius of the touch area (default: 1.0).
   */
  @Nullable
  private final Double radiusX;

  /**
   * Y radius of the touch area (default: 1.0).
   */
  @Nullable
  private final Double radiusY;

  /**
   * Rotation angle (default: 0.0).
   */
  @Nullable
  private final Double rotationAngle;

  /**
   * Force (default: 1.0).
   */
  @Nullable
  private final Double force;

  /**
   * The normalized tangential pressure, which has a range of [-1,1] (default: 0).
   */
  @Nullable
  @Experimental
  private final Double tangentialPressure;

  /**
   * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0)
   */
  @Nullable
  private final Double tiltX;

  /**
   * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).
   */
  @Nullable
  private final Double tiltY;

  /**
   * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range [0,359] (default: 0).
   */
  @Nullable
  @Experimental
  private final Integer twist;

  /**
   * Identifier used to track touch sources between events, must be unique within an event.
   */
  @Nullable
  private final Double id;
}
