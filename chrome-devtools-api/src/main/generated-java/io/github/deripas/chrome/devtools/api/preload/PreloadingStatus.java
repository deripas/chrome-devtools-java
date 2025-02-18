package io.github.deripas.chrome.devtools.api.preload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Preloading status values, see also PreloadingTriggeringOutcome. This
 * status is shared by prefetchStatusUpdated and prerenderStatusUpdated.
 */
@Generated
public enum PreloadingStatus {
  @JsonProperty("Pending")
  PENDING,

  @JsonProperty("Running")
  RUNNING,

  @JsonProperty("Ready")
  READY,

  @JsonProperty("Success")
  SUCCESS,

  @JsonProperty("Failure")
  FAILURE,

  @JsonProperty("NotSupported")
  NOT_SUPPORTED
}
