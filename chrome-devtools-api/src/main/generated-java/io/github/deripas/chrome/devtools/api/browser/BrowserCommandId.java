package io.github.deripas.chrome.devtools.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Browser command ids used by executeBrowserCommand.
 */
@Experimental
@Generated
public enum BrowserCommandId {
  @JsonProperty("openTabSearch")
  OPEN_TAB_SEARCH,

  @JsonProperty("closeTabSearch")
  CLOSE_TAB_SEARCH
}
