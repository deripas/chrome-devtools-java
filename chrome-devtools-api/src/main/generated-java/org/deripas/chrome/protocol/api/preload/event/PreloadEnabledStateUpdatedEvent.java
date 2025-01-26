package org.deripas.chrome.protocol.api.preload.event;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when a preload enabled state is updated.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PreloadEnabledStateUpdatedEvent {
  public static final EventId<PreloadEnabledStateUpdatedEvent> ID = new EventId<>("Preload.preloadEnabledStateUpdated", PreloadEnabledStateUpdatedEvent.class);

  private final Boolean disabledByPreference;

  private final Boolean disabledByDataSaver;

  private final Boolean disabledByBatterySaver;

  private final Boolean disabledByHoldbackPrefetchSpeculationRules;

  private final Boolean disabledByHoldbackPrerenderSpeculationRules;
}
