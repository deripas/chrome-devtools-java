package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Source of service worker router.
 */
@Generated
public enum ServiceWorkerRouterSource {
  @JsonProperty("network")
  NETWORK,

  @JsonProperty("cache")
  CACHE,

  @JsonProperty("fetch-event")
  FETCH_EVENT,

  @JsonProperty("race-network-and-fetch-handler")
  RACE_NETWORK_AND_FETCH_HANDLER
}
