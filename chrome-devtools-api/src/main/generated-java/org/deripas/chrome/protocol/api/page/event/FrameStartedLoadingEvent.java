package org.deripas.chrome.protocol.api.page.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when frame has started loading.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameStartedLoadingEvent {
  public static final EventId<FrameStartedLoadingEvent> ID = new EventId<>("Page.frameStartedLoading", FrameStartedLoadingEvent.class);

  /**
   * Id of the frame that has started loading.
   */
  private final FrameId frameId;
}
