package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

@Experimental
@Generated
public enum ClientNavigationDisposition {
  @JsonProperty("currentTab")
  CURRENT_TAB,

  @JsonProperty("newTab")
  NEW_TAB,

  @JsonProperty("newWindow")
  NEW_WINDOW,

  @JsonProperty("download")
  DOWNLOAD
}
