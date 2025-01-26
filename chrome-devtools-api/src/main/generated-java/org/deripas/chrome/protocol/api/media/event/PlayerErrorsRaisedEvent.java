package org.deripas.chrome.protocol.api.media.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.media.PlayerError;
import org.deripas.chrome.protocol.api.media.PlayerId;

/**
 * Send a list of any errors that need to be delivered.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerErrorsRaisedEvent {
  public static final EventId<PlayerErrorsRaisedEvent> ID = new EventId<>("Media.playerErrorsRaised", PlayerErrorsRaisedEvent.class);

  private final PlayerId playerId;

  private final List<PlayerError> errors;
}
