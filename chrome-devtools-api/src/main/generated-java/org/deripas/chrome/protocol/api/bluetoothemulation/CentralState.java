package org.deripas.chrome.protocol.api.bluetoothemulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Indicates the various states of Central.
 */
@Generated
public enum CentralState {
  @JsonProperty("absent")
  ABSENT,

  @JsonProperty("powered-off")
  POWERED_OFF,

  @JsonProperty("powered-on")
  POWERED_ON
}
