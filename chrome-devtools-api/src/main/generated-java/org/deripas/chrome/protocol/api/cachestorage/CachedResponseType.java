package org.deripas.chrome.protocol.api.cachestorage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * type of HTTP response cached
 */
@Generated
public enum CachedResponseType {
  @JsonProperty("basic")
  BASIC,

  @JsonProperty("cors")
  CORS,

  @JsonProperty("default")
  DEFAULT,

  @JsonProperty("error")
  ERROR,

  @JsonProperty("opaqueResponse")
  OPAQUE_RESPONSE,

  @JsonProperty("opaqueRedirect")
  OPAQUE_REDIRECT
}
