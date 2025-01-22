package org.deripas.chrome.protocol.api.webaudio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of AudioParam::AutomationRate from the spec
 */
@Generated
public enum AutomationRate {
  @JsonProperty("a-rate")
  A_RATE,

  @JsonProperty("k-rate")
  K_RATE
}
