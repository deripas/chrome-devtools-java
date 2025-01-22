package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum ContentSecurityPolicySource {
  @JsonProperty("HTTP")
  H_T_T_P,

  @JsonProperty("Meta")
  META
}
