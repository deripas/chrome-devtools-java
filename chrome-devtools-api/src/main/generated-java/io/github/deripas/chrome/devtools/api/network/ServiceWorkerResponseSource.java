package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Source of serviceworker response.
 */
@Generated
public enum ServiceWorkerResponseSource {
  @JsonProperty("cache-storage")
  CACHE_STORAGE,

  @JsonProperty("http-cache")
  HTTP_CACHE,

  @JsonProperty("fallback-code")
  FALLBACK_CODE,

  @JsonProperty("network")
  NETWORK
}
