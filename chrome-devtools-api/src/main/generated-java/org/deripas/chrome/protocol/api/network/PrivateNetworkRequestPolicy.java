package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum PrivateNetworkRequestPolicy {
  @JsonProperty("Allow")
  ALLOW,

  @JsonProperty("BlockFromInsecureToMorePrivate")
  BLOCK_FROM_INSECURE_TO_MORE_PRIVATE,

  @JsonProperty("WarnFromInsecureToMorePrivate")
  WARN_FROM_INSECURE_TO_MORE_PRIVATE,

  @JsonProperty("PreflightBlock")
  PREFLIGHT_BLOCK,

  @JsonProperty("PreflightWarn")
  PREFLIGHT_WARN
}
