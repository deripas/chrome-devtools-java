package org.deripas.chrome.protocol.api.backgroundservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The Background Service that will be associated with the commands/events.
 * Every Background Service operates independently, but they share the same
 * API.
 */
@Generated
public enum ServiceName {
  @JsonProperty("backgroundFetch")
  BACKGROUND_FETCH,

  @JsonProperty("backgroundSync")
  BACKGROUND_SYNC,

  @JsonProperty("pushMessaging")
  PUSH_MESSAGING,

  @JsonProperty("notifications")
  NOTIFICATIONS,

  @JsonProperty("paymentHandler")
  PAYMENT_HANDLER,

  @JsonProperty("periodicBackgroundSync")
  PERIODIC_BACKGROUND_SYNC
}
