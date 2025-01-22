package org.deripas.chrome.protocol.api.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * A description of mixed content (HTTP resources on HTTPS pages), as defined by
 * https://www.w3.org/TR/mixed-content/#categories
 */
@Generated
public enum MixedContentType {
  @JsonProperty("blockable")
  BLOCKABLE,

  @JsonProperty("optionally-blockable")
  OPTIONALLY_BLOCKABLE,

  @JsonProperty("none")
  NONE
}
