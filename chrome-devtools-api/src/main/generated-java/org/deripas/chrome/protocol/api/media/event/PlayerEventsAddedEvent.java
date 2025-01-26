package org.deripas.chrome.protocol.api.media.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.media.PlayerEvent;
import org.deripas.chrome.protocol.api.media.PlayerId;

/**
 * Send events as a list, allowing them to be batched on the browser for less
 * congestion. If batched, events must ALWAYS be in chronological order.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerEventsAddedEvent {
  public static final EventId<PlayerEventsAddedEvent> ID = new EventId<>("Media.playerEventsAdded", PlayerEventsAddedEvent.class);

  private final PlayerId playerId;

  private final List<PlayerEvent> events;
}
