package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum IPAddressSpace {
  @JsonProperty("Local")
  LOCAL,

  @JsonProperty("Private")
  PRIVATE,

  @JsonProperty("Public")
  PUBLIC,

  @JsonProperty("Unknown")
  UNKNOWN
}
