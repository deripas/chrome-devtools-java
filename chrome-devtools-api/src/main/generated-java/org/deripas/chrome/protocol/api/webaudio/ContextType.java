package org.deripas.chrome.protocol.api.webaudio;

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
