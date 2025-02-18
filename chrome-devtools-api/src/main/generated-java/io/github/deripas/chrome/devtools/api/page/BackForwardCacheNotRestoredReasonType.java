package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Types of not restored reasons for back-forward cache.
 */
@Experimental
@Generated
public enum BackForwardCacheNotRestoredReasonType {
  @JsonProperty("SupportPending")
  SUPPORT_PENDING,

  @JsonProperty("PageSupportNeeded")
  PAGE_SUPPORT_NEEDED,

  @JsonProperty("Circumstantial")
  CIRCUMSTANTIAL
}
