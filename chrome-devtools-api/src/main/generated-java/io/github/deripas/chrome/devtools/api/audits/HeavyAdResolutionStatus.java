package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum HeavyAdResolutionStatus {
  @JsonProperty("HeavyAdBlocked")
  HEAVY_AD_BLOCKED,

  @JsonProperty("HeavyAdWarning")
  HEAVY_AD_WARNING
}
