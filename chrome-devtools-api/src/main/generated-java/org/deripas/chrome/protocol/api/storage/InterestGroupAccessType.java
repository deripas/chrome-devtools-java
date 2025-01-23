package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of interest group access types.
 */
@Generated
public enum InterestGroupAccessType {
  @JsonProperty("join")
  JOIN,

  @JsonProperty("leave")
  LEAVE,

  @JsonProperty("update")
  UPDATE,

  @JsonProperty("loaded")
  LOADED,

  @JsonProperty("bid")
  BID,

  @JsonProperty("win")
  WIN,

  @JsonProperty("additionalBid")
  ADDITIONAL_BID,

  @JsonProperty("additionalBidWin")
  ADDITIONAL_BID_WIN,

  @JsonProperty("topLevelBid")
  TOP_LEVEL_BID,

  @JsonProperty("topLevelAdditionalBid")
  TOP_LEVEL_ADDITIONAL_BID,

  @JsonProperty("clear")
  CLEAR
}
