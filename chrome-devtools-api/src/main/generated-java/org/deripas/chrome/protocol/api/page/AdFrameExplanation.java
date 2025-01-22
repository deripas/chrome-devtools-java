package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum AdFrameExplanation {
  @JsonProperty("ParentIsAd")
  PARENT_IS_AD,

  @JsonProperty("CreatedByAdScript")
  CREATED_BY_AD_SCRIPT,

  @JsonProperty("MatchedBlockingRule")
  MATCHED_BLOCKING_RULE
}
