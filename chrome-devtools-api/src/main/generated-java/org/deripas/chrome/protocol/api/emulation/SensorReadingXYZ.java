package org.deripas.chrome.protocol.api.emulation;

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
public class SensorReadingXYZ {
  private final Double x;

  private final Double y;

  private final Double z;
}
