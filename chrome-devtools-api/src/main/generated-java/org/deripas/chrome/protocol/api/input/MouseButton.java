package org.deripas.chrome.protocol.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum MouseButton {
  @JsonProperty("none")
  NONE,

  @JsonProperty("left")
  LEFT,

  @JsonProperty("middle")
  MIDDLE,

  @JsonProperty("right")
  RIGHT,

  @JsonProperty("back")
  BACK,

  @JsonProperty("forward")
  FORWARD
}
