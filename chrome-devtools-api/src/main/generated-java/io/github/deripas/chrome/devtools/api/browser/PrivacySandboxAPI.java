package io.github.deripas.chrome.devtools.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum PrivacySandboxAPI {
  @JsonProperty("BiddingAndAuctionServices")
  BIDDING_AND_AUCTION_SERVICES,

  @JsonProperty("TrustedKeyValue")
  TRUSTED_KEY_VALUE
}
