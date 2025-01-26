package org.deripas.chrome.protocol.api.backgroundservice.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.backgroundservice.BackgroundServiceEvent;

/**
 * Called with all existing backgroundServiceEvents when enabled, and all new
 * events afterwards if enabled and recording.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BackgroundServiceEventReceivedEvent {
  public static final EventId<BackgroundServiceEventReceivedEvent> ID = new EventId<>("BackgroundService.backgroundServiceEventReceived", BackgroundServiceEventReceivedEvent.class);

  private final BackgroundServiceEvent backgroundServiceEvent;
}
