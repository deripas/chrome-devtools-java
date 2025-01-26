package org.deripas.chrome.protocol.api.preload.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.page.FrameId;
import org.deripas.chrome.protocol.api.preload.PrefetchStatus;
import org.deripas.chrome.protocol.api.preload.PreloadPipelineId;
import org.deripas.chrome.protocol.api.preload.PreloadingAttemptKey;
import org.deripas.chrome.protocol.api.preload.PreloadingStatus;

/**
 * Fired when a prefetch attempt is updated.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PrefetchStatusUpdatedEvent {
  public static final EventId<PrefetchStatusUpdatedEvent> ID = new EventId<>("Preload.prefetchStatusUpdated", PrefetchStatusUpdatedEvent.class);

  private final PreloadingAttemptKey key;

  private final PreloadPipelineId pipelineId;

  /**
   * The frame id of the frame initiating prefetch.
   */
  private final FrameId initiatingFrameId;

  private final String prefetchUrl;

  private final PreloadingStatus status;

  private final PrefetchStatus prefetchStatus;

  private final RequestId requestId;
}
