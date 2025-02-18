package io.github.deripas.chrome.devtools.api.emulation;

import java.lang.Boolean;
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
public class PressureMetadata {
  @Nullable
  private final Boolean available;
}
