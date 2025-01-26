package org.deripas.chrome.protocol.api.media.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.media.PlayerId;
import org.deripas.chrome.protocol.api.media.PlayerMessage;

/**
 * Send a list of any messages that need to be delivered.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerMessagesLoggedEvent {
  public static final EventId<PlayerMessagesLoggedEvent> ID = new EventId<>("Media.playerMessagesLogged", PlayerMessagesLoggedEvent.class);

  private final PlayerId playerId;

  private final List<PlayerMessage> messages;
}
