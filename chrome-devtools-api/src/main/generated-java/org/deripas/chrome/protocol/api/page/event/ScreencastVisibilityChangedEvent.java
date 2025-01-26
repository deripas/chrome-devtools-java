package org.deripas.chrome.protocol.api.page.event;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when the page with currently enabled screencast was shown or hidden `.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScreencastVisibilityChangedEvent {
  public static final EventId<ScreencastVisibilityChangedEvent> ID = new EventId<>("Page.screencastVisibilityChanged", ScreencastVisibilityChangedEvent.class);

  /**
   * True if the page is visible.
   */
  private final Boolean visible;
}
