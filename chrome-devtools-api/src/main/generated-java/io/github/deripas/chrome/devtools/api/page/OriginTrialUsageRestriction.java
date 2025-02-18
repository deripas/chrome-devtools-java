package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum OriginTrialUsageRestriction {
  @JsonProperty("None")
  NONE,

  @JsonProperty("Subset")
  SUBSET
}
