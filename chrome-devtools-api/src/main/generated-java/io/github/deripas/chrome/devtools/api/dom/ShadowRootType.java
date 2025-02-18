package io.github.deripas.chrome.devtools.api.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Shadow root type.
 */
@Generated
public enum ShadowRootType {
  @JsonProperty("user-agent")
  USER_AGENT,

  @JsonProperty("open")
  OPEN,

  @JsonProperty("closed")
  CLOSED
}
