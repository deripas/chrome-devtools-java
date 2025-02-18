package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum MixedContentResolutionStatus {
  @JsonProperty("MixedContentBlocked")
  MIXED_CONTENT_BLOCKED,

  @JsonProperty("MixedContentAutomaticallyUpgraded")
  MIXED_CONTENT_AUTOMATICALLY_UPGRADED,

  @JsonProperty("MixedContentWarning")
  MIXED_CONTENT_WARNING
}
