package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Indicates whether a frame has been identified as an ad.
 */
@Experimental
@Generated
public enum AdFrameType {
  @JsonProperty("none")
  NONE,

  @JsonProperty("child")
  CHILD,

  @JsonProperty("root")
  ROOT
}
