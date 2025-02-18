package io.github.deripas.chrome.devtools.api.serviceworker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum ServiceWorkerVersionStatus {
  @JsonProperty("new")
  NEW,

  @JsonProperty("installing")
  INSTALLING,

  @JsonProperty("installed")
  INSTALLED,

  @JsonProperty("activating")
  ACTIVATING,

  @JsonProperty("activated")
  ACTIVATED,

  @JsonProperty("redundant")
  REDUNDANT
}
