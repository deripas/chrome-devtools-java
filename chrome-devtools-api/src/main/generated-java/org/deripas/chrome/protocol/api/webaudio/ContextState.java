package org.deripas.chrome.protocol.api.webaudio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of AudioContextState from the spec
 */
@Generated
public enum ContextState {
  @JsonProperty("suspended")
  SUSPENDED,

  @JsonProperty("running")
  RUNNING,

  @JsonProperty("closed")
  CLOSED,

  @JsonProperty("interrupted")
  INTERRUPTED
}
