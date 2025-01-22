package org.deripas.chrome.protocol.api.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * ContainerSelector physical axes
 */
@Generated
public enum PhysicalAxes {
  @JsonProperty("Horizontal")
  HORIZONTAL,

  @JsonProperty("Vertical")
  VERTICAL,

  @JsonProperty("Both")
  BOTH
}
