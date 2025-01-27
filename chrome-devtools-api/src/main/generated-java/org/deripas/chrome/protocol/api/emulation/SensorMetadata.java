package org.deripas.chrome.protocol.api.emulation;

import java.lang.Boolean;
import java.lang.Double;
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
public class SensorMetadata {
  @Nullable
  private final Boolean available;

  @Nullable
  private final Double minimumFrequency;

  @Nullable
  private final Double maximumFrequency;
}
