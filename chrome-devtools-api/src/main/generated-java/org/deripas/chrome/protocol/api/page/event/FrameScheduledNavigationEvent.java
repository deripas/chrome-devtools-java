package org.deripas.chrome.protocol.api.page.event;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.ClientNavigationReason;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when frame schedules a potential navigation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameScheduledNavigationEvent {
  public static final EventId<FrameScheduledNavigationEvent> ID = new EventId<>("Page.frameScheduledNavigation", FrameScheduledNavigationEvent.class);

  /**
   * Id of the frame that has scheduled a navigation.
   */
  private final FrameId frameId;

  /**
   * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not
   * guaranteed to start.
   */
  private final Double delay;

  /**
   * The reason for the navigation.
   */
  private final ClientNavigationReason reason;

  /**
   * The destination URL for the scheduled navigation.
   */
  private final String url;
}
