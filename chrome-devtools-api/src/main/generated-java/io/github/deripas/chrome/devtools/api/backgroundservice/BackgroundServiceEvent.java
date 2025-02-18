package io.github.deripas.chrome.devtools.api.backgroundservice;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;
import io.github.deripas.chrome.devtools.api.serviceworker.RegistrationID;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class BackgroundServiceEvent {
  /**
   * Timestamp of the event (in seconds).
   */
  private final TimeSinceEpoch timestamp;

  /**
   * The origin this event belongs to.
   */
  private final String origin;

  /**
   * The Service Worker ID that initiated the event.
   */
  private final RegistrationID serviceWorkerRegistrationId;

  /**
   * The Background Service this event belongs to.
   */
  private final ServiceName service;

  /**
   * A description of the event.
   */
  private final String eventName;

  /**
   * An identifier that groups related events together.
   */
  private final String instanceId;

  /**
   * A list of event-specific information.
   */
  private final List<EventMetadata> eventMetadata;

  /**
   * Storage key this event belongs to.
   */
  private final String storageKey;
}
