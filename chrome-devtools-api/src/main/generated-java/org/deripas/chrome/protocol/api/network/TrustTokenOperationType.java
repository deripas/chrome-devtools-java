package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum TrustTokenOperationType {
  @JsonProperty("Issuance")
  ISSUANCE,

  @JsonProperty("Redemption")
  REDEMPTION,

  @JsonProperty("Signing")
  SIGNING
}
