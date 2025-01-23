package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Represents the cookie's 'SameSite' status:
 * https://tools.ietf.org/html/draft-west-first-party-cookies
 */
@Generated
public enum CookieSameSite {
  @JsonProperty("Strict")
  STRICT,

  @JsonProperty("Lax")
  LAX,

  @JsonProperty("None")
  NONE
}
