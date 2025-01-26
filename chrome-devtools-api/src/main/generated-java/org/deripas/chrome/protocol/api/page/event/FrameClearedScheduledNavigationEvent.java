package org.deripas.chrome.protocol.api.page.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when frame no longer has a scheduled navigation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameClearedScheduledNavigationEvent {
  public static final EventId<FrameClearedScheduledNavigationEvent> ID = new EventId<>("Page.frameClearedScheduledNavigation", FrameClearedScheduledNavigationEvent.class);

  /**
   * Id of the frame that has cleared its scheduled navigation.
   */
  private final FrameId frameId;
}
