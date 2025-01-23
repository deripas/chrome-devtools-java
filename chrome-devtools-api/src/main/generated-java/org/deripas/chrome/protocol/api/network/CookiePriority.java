package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Represents the cookie's 'Priority' status:
 * https://tools.ietf.org/html/draft-west-cookie-priority-00
 */
@Experimental
@Generated
public enum CookiePriority {
  @JsonProperty("Low")
  LOW,

  @JsonProperty("Medium")
  MEDIUM,

  @JsonProperty("High")
  HIGH
}
