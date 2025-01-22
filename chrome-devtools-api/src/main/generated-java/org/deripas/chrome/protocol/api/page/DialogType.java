package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Javascript dialog type.
 */
@Generated
public enum DialogType {
  @JsonProperty("alert")
  ALERT,

  @JsonProperty("confirm")
  CONFIRM,

  @JsonProperty("prompt")
  PROMPT,

  @JsonProperty("beforeunload")
  BEFOREUNLOAD
}
