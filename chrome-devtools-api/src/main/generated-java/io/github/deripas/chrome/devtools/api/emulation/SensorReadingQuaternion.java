package io.github.deripas.chrome.devtools.api.emulation;

import java.lang.Double;
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
public class SensorReadingQuaternion {
  private final Double x;

  private final Double y;

  private final Double z;

  private final Double w;
}
