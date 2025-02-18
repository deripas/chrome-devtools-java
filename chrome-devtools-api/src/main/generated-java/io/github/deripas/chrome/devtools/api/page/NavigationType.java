package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * The type of a frameNavigated event.
 */
@Experimental
@Generated
public enum NavigationType {
  @JsonProperty("Navigation")
  NAVIGATION,

  @JsonProperty("BackForwardCacheRestore")
  BACK_FORWARD_CACHE_RESTORE
}
