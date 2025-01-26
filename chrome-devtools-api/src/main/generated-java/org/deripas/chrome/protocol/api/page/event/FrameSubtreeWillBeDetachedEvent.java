package org.deripas.chrome.protocol.api.page.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired before frame subtree is detached. Emitted before any frame of the
 * subtree is actually detached.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameSubtreeWillBeDetachedEvent {
  public static final EventId<FrameSubtreeWillBeDetachedEvent> ID = new EventId<>("Page.frameSubtreeWillBeDetached", FrameSubtreeWillBeDetachedEvent.class);

  /**
   * Id of the frame that is the root of the subtree that will be detached.
   */
  private final FrameId frameId;
}
