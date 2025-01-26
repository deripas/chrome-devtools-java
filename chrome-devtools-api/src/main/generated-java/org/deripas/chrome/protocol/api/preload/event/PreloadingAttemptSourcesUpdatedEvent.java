package org.deripas.chrome.protocol.api.preload.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.preload.PreloadingAttemptSource;

/**
 * Send a list of sources for all preloading attempts in a document.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PreloadingAttemptSourcesUpdatedEvent {
  public static final EventId<PreloadingAttemptSourcesUpdatedEvent> ID = new EventId<>("Preload.preloadingAttemptSourcesUpdated", PreloadingAttemptSourcesUpdatedEvent.class);

  private final LoaderId loaderId;

  private final List<PreloadingAttemptSource> preloadingAttemptSources;
}
