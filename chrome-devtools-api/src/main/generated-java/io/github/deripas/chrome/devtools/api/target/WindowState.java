package io.github.deripas.chrome.devtools.api.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * The state of the target window.
 */
@Experimental
@Generated
public enum WindowState {
  @JsonProperty("normal")
  NORMAL,

  @JsonProperty("minimized")
  MINIMIZED,

  @JsonProperty("maximized")
  MAXIMIZED,

  @JsonProperty("fullscreen")
  FULLSCREEN
}
