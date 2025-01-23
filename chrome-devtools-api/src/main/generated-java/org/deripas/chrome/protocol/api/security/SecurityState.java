package org.deripas.chrome.protocol.api.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The security level of a page or resource.
 */
@Generated
public enum SecurityState {
  @JsonProperty("unknown")
  UNKNOWN,

  @JsonProperty("neutral")
  NEUTRAL,

  @JsonProperty("insecure")
  INSECURE,

  @JsonProperty("secure")
  SECURE,

  @JsonProperty("info")
  INFO,

  @JsonProperty("insecure-broken")
  INSECURE_BROKEN
}
