package org.deripas.chrome.protocol.api.pwa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * If user prefers opening the app in browser or an app window.
 */
@Generated
public enum DisplayMode {
  @JsonProperty("standalone")
  STANDALONE,

  @JsonProperty("browser")
  BROWSER
}
