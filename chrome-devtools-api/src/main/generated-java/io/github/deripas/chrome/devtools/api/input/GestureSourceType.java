package io.github.deripas.chrome.devtools.api.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum GestureSourceType {
  @JsonProperty("default")
  DEFAULT,

  @JsonProperty("touch")
  TOUCH,

  @JsonProperty("mouse")
  MOUSE
}
