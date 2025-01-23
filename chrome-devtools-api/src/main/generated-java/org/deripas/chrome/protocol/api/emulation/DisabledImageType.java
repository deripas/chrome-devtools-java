package org.deripas.chrome.protocol.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Enum of image types that can be disabled.
 */
@Experimental
@Generated
public enum DisabledImageType {
  @JsonProperty("avif")
  AVIF,

  @JsonProperty("webp")
  WEBP
}
