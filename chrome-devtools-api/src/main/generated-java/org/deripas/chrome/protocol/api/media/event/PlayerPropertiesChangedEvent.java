package org.deripas.chrome.protocol.api.media.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.media.PlayerId;
import org.deripas.chrome.protocol.api.media.PlayerProperty;

/**
 * This can be called multiple times, and can be used to set / override /
 * remove player properties. A null propValue indicates removal.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerPropertiesChangedEvent {
  public static final EventId<PlayerPropertiesChangedEvent> ID = new EventId<>("Media.playerPropertiesChanged", PlayerPropertiesChangedEvent.class);

  private final PlayerId playerId;

  private final List<PlayerProperty> properties;
}
