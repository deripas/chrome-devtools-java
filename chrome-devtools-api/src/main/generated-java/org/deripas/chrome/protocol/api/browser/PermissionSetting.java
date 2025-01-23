package org.deripas.chrome.protocol.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum PermissionSetting {
  @JsonProperty("granted")
  GRANTED,

  @JsonProperty("denied")
  DENIED,

  @JsonProperty("prompt")
  PROMPT
}
