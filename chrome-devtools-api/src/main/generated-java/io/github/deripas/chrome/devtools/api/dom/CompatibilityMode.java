package io.github.deripas.chrome.devtools.api.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Document compatibility mode.
 */
@Generated
public enum CompatibilityMode {
  @JsonProperty("QuirksMode")
  QUIRKS_MODE,

  @JsonProperty("LimitedQuirksMode")
  LIMITED_QUIRKS_MODE,

  @JsonProperty("NoQuirksMode")
  NO_QUIRKS_MODE
}
