package io.github.deripas.chrome.devtools.api.overlay;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum InspectMode {
  @JsonProperty("searchForNode")
  SEARCH_FOR_NODE,

  @JsonProperty("searchForUAShadowDOM")
  SEARCH_FOR_U_A_SHADOW_D_O_M,

  @JsonProperty("captureAreaScreenshot")
  CAPTURE_AREA_SCREENSHOT,

  @JsonProperty("showDistances")
  SHOW_DISTANCES,

  @JsonProperty("none")
  NONE
}
