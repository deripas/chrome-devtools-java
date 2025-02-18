package io.github.deripas.chrome.devtools.api.css;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Stylesheet type: "injected" for stylesheets injected via extension, "user-agent" for user-agent
 * stylesheets, "inspector" for stylesheets created by the inspector (i.e. those holding the "via
 * inspector" rules), "regular" for regular stylesheets.
 */
@Generated
public enum StyleSheetOrigin {
  @JsonProperty("injected")
  INJECTED,

  @JsonProperty("user-agent")
  USER_AGENT,

  @JsonProperty("inspector")
  INSPECTOR,

  @JsonProperty("regular")
  REGULAR
}
