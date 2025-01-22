package org.deripas.chrome.protocol.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum PressureState {
  @JsonProperty("nominal")
  NOMINAL,

  @JsonProperty("fair")
  FAIR,

  @JsonProperty("serious")
  SERIOUS,

  @JsonProperty("critical")
  CRITICAL
}
