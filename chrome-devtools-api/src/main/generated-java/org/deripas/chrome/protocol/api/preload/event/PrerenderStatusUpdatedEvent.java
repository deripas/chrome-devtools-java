package org.deripas.chrome.protocol.api.preload.event;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.preload.PreloadPipelineId;
import org.deripas.chrome.protocol.api.preload.PreloadingAttemptKey;
import org.deripas.chrome.protocol.api.preload.PreloadingStatus;
import org.deripas.chrome.protocol.api.preload.PrerenderFinalStatus;
import org.deripas.chrome.protocol.api.preload.PrerenderMismatchedHeaders;

/**
 * Fired when a prerender attempt is updated.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PrerenderStatusUpdatedEvent {
  public static final EventId<PrerenderStatusUpdatedEvent> ID = new EventId<>("Preload.prerenderStatusUpdated", PrerenderStatusUpdatedEvent.class);

  private final PreloadingAttemptKey key;

  private final PreloadPipelineId pipelineId;

  private final PreloadingStatus status;

  @Nullable
  private final PrerenderFinalStatus prerenderStatus;

  /**
   * This is used to give users more information about the name of Mojo interface
   * that is incompatible with prerender and has caused the cancellation of the attempt.
   */
  @Nullable
  private final String disallowedMojoInterface;

  @Nullable
  private final List<PrerenderMismatchedHeaders> mismatchedHeaders;
}
