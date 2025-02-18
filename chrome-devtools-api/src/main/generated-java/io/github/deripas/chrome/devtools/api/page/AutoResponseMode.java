package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Enum of possible auto-response for permission / prompt dialogs.
 */
@Experimental
@Generated
public enum AutoResponseMode {
  @JsonProperty("none")
  NONE,

  @JsonProperty("autoAccept")
  AUTO_ACCEPT,

  @JsonProperty("autoReject")
  AUTO_REJECT,

  @JsonProperty("autoOptOut")
  AUTO_OPT_OUT
}
