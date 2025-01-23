package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of auction events.
 */
@Generated
public enum InterestGroupAuctionEventType {
  @JsonProperty("started")
  STARTED,

  @JsonProperty("configResolved")
  CONFIG_RESOLVED
}
