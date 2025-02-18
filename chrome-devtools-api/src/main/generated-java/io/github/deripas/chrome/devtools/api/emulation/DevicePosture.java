package io.github.deripas.chrome.devtools.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class DevicePosture {
  /**
   * Current posture of the device
   */
  private final Type type;

  public enum Type {
    @JsonProperty("continuous")
    CONTINUOUS,

    @JsonProperty("folded")
    FOLDED
  }
}
