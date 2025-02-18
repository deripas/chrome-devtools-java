package io.github.deripas.chrome.devtools.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Used to specify sensor types to emulate.
 * See https://w3c.github.io/sensors/#automation for more information.
 */
@Experimental
@Generated
public enum SensorType {
  @JsonProperty("absolute-orientation")
  ABSOLUTE_ORIENTATION,

  @JsonProperty("accelerometer")
  ACCELEROMETER,

  @JsonProperty("ambient-light")
  AMBIENT_LIGHT,

  @JsonProperty("gravity")
  GRAVITY,

  @JsonProperty("gyroscope")
  GYROSCOPE,

  @JsonProperty("linear-acceleration")
  LINEAR_ACCELERATION,

  @JsonProperty("magnetometer")
  MAGNETOMETER,

  @JsonProperty("relative-orientation")
  RELATIVE_ORIENTATION
}
