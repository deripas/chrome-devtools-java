package org.deripas.chrome.protocol.api.overlay.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.Viewport;

/**
 * Fired when user asks to capture screenshot of some area on the page.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScreenshotRequestedEvent {
  public static final EventId<ScreenshotRequestedEvent> ID = new EventId<>("Overlay.screenshotRequested", ScreenshotRequestedEvent.class);

  /**
   * Viewport to capture, in device independent pixels (dip).
   */
  private final Viewport viewport;
}
