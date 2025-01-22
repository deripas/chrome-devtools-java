package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Loading priority of a resource request.
 */
@Generated
public enum ResourcePriority {
  @JsonProperty("VeryLow")
  VERY_LOW,

  @JsonProperty("Low")
  LOW,

  @JsonProperty("Medium")
  MEDIUM,

  @JsonProperty("High")
  HIGH,

  @JsonProperty("VeryHigh")
  VERY_HIGH
}
