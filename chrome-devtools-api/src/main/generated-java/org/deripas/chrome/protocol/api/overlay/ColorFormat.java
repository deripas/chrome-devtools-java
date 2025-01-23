package org.deripas.chrome.protocol.api.overlay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum ColorFormat {
  @JsonProperty("rgb")
  RGB,

  @JsonProperty("hsl")
  HSL,

  @JsonProperty("hwb")
  HWB,

  @JsonProperty("hex")
  HEX
}
