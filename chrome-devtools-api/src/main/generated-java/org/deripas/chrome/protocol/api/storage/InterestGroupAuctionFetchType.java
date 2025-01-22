package org.deripas.chrome.protocol.api.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of network fetches auctions can do.
 */
@Generated
public enum InterestGroupAuctionFetchType {
  @JsonProperty("bidderJs")
  BIDDER_JS,

  @JsonProperty("bidderWasm")
  BIDDER_WASM,

  @JsonProperty("sellerJs")
  SELLER_JS,

  @JsonProperty("bidderTrustedSignals")
  BIDDER_TRUSTED_SIGNALS,

  @JsonProperty("sellerTrustedSignals")
  SELLER_TRUSTED_SIGNALS
}
