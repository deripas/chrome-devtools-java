package org.deripas.chrome.protocol.api.emulation;

import java.lang.Long;
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
public class SensorReadingSingle {
  private final Long value;
}
