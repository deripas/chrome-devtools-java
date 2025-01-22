package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum CrossOriginOpenerPolicyValue {
  @JsonProperty("SameOrigin")
  SAME_ORIGIN,

  @JsonProperty("SameOriginAllowPopups")
  SAME_ORIGIN_ALLOW_POPUPS,

  @JsonProperty("RestrictProperties")
  RESTRICT_PROPERTIES,

  @JsonProperty("UnsafeNone")
  UNSAFE_NONE,

  @JsonProperty("SameOriginPlusCoep")
  SAME_ORIGIN_PLUS_COEP,

  @JsonProperty("RestrictPropertiesPlusCoep")
  RESTRICT_PROPERTIES_PLUS_COEP,

  @JsonProperty("NoopenerAllowPopups")
  NOOPENER_ALLOW_POPUPS
}
