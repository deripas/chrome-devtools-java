package org.deripas.chrome.protocol.api.media.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.media.PlayerId;

/**
 * Called whenever a player is created, or when a new agent joins and receives
 * a list of active players. If an agent is restored, it will receive the full
 * list of player ids and all events again.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayersCreatedEvent {
  public static final EventId<PlayersCreatedEvent> ID = new EventId<>("Media.playersCreated", PlayersCreatedEvent.class);

  private final List<PlayerId> players;
}
