package io.github.deripas.chrome.devtools.api.serviceworker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum ServiceWorkerVersionRunningStatus {
  @JsonProperty("stopped")
  STOPPED,

  @JsonProperty("starting")
  STARTING,

  @JsonProperty("running")
  RUNNING,

  @JsonProperty("stopping")
  STOPPING
}
