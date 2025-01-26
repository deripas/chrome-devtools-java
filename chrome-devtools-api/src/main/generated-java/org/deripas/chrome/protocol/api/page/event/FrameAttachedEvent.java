package org.deripas.chrome.protocol.api.page.event;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;
import org.deripas.chrome.protocol.api.runtime.StackTrace;

/**
 * Fired when frame has been attached to its parent.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameAttachedEvent {
  public static final EventId<FrameAttachedEvent> ID = new EventId<>("Page.frameAttached", FrameAttachedEvent.class);

  /**
   * Id of the frame that has been attached.
   */
  private final FrameId frameId;

  /**
   * Parent frame identifier.
   */
  private final FrameId parentFrameId;

  /**
   * JavaScript stack trace of when frame was attached, only set if frame initiated from script.
   */
  @Nullable
  private final StackTrace stack;
}
