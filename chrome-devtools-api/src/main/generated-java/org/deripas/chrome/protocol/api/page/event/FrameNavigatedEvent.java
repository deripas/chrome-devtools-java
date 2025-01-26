package org.deripas.chrome.protocol.api.page.event;

import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.Frame;
import org.deripas.chrome.protocol.api.page.NavigationType;

/**
 * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameNavigatedEvent {
  public static final EventId<FrameNavigatedEvent> ID = new EventId<>("Page.frameNavigated", FrameNavigatedEvent.class);

  /**
   * Frame object.
   */
  private final Frame frame;

  @Experimental
  private final NavigationType type;
}
