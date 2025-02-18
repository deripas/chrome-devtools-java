package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Represents the category of insight that a cookie issue falls under.
 */
@Generated
public enum InsightType {
  @JsonProperty("GitHubResource")
  GIT_HUB_RESOURCE,

  @JsonProperty("GracePeriod")
  GRACE_PERIOD,

  @JsonProperty("Heuristics")
  HEURISTICS
}
