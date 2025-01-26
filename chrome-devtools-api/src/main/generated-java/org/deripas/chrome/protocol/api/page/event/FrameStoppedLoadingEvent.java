package org.deripas.chrome.protocol.api.page.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when frame has stopped loading.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameStoppedLoadingEvent {
  public static final EventId<FrameStoppedLoadingEvent> ID = new EventId<>("Page.frameStoppedLoading", FrameStoppedLoadingEvent.class);

  /**
   * Id of the frame that has stopped loading.
   */
  private final FrameId frameId;
}
