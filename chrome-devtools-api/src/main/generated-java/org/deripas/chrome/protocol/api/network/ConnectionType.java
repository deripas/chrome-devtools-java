package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The underlying connection technology that the browser is supposedly using.
 */
@Generated
public enum ConnectionType {
  @JsonProperty("none")
  NONE,

  @JsonProperty("cellular2g")
  CELLULAR2G,

  @JsonProperty("cellular3g")
  CELLULAR3G,

  @JsonProperty("cellular4g")
  CELLULAR4G,

  @JsonProperty("bluetooth")
  BLUETOOTH,

  @JsonProperty("ethernet")
  ETHERNET,

  @JsonProperty("wifi")
  WIFI,

  @JsonProperty("wimax")
  WIMAX,

  @JsonProperty("other")
  OTHER
}
