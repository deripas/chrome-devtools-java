package org.deripas.chrome.protocol.api.systeminfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Image format of a given image.
 */
@Generated
public enum ImageType {
  @JsonProperty("jpeg")
  JPEG,

  @JsonProperty("webp")
  WEBP,

  @JsonProperty("unknown")
  UNKNOWN
}
