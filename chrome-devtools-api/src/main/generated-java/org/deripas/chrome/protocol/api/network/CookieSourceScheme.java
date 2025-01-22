package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Represents the source scheme of the origin that originally set the cookie.
 * A value of "Unset" allows protocol clients to emulate legacy cookie scope for the scheme.
 * This is a temporary ability and it will be removed in the future.
 */
@Experimental
@Generated
public enum CookieSourceScheme {
  @JsonProperty("Unset")
  UNSET,

  @JsonProperty("NonSecure")
  NON_SECURE,

  @JsonProperty("Secure")
  SECURE
}
