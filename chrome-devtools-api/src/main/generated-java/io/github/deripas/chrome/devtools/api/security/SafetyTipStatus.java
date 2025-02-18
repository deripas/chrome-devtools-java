package io.github.deripas.chrome.devtools.api.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum SafetyTipStatus {
  @JsonProperty("badReputation")
  BAD_REPUTATION,

  @JsonProperty("lookalike")
  LOOKALIKE
}
