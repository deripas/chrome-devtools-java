package org.deripas.chrome.protocol.api.page.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.ClientNavigationDisposition;
import org.deripas.chrome.protocol.api.page.ClientNavigationReason;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when a renderer-initiated navigation is requested.
 * Navigation may still be cancelled after the event is issued.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameRequestedNavigationEvent {
  public static final EventId<FrameRequestedNavigationEvent> ID = new EventId<>("Page.frameRequestedNavigation", FrameRequestedNavigationEvent.class);

  /**
   * Id of the frame that is being navigated.
   */
  private final FrameId frameId;

  /**
   * The reason for the navigation.
   */
  private final ClientNavigationReason reason;

  /**
   * The destination URL for the requested navigation.
   */
  private final String url;

  /**
   * The disposition for the navigation.
   */
  private final ClientNavigationDisposition disposition;
}
