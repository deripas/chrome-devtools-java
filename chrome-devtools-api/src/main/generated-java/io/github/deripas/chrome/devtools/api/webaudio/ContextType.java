package io.github.deripas.chrome.devtools.api.webaudio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of BaseAudioContext types
 */
@Generated
public enum ContextType {
  @JsonProperty("realtime")
  REALTIME,

  @JsonProperty("offline")
  OFFLINE
}
