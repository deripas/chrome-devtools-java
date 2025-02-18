package io.github.deripas.chrome.devtools.api.emulation;

import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class SensorReading {
  @Nullable
  private final SensorReadingSingle single;

  @Nullable
  private final SensorReadingXYZ xyz;

  @Nullable
  private final SensorReadingQuaternion quaternion;
}
