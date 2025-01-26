package org.deripas.chrome.protocol.api.page.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired for lifecycle events (navigation, load, paint, etc) in the current
 * target (including local frames).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LifecycleEventEvent {
  public static final EventId<LifecycleEventEvent> ID = new EventId<>("Page.lifecycleEvent", LifecycleEventEvent.class);

  /**
   * Id of the frame.
   */
  private final FrameId frameId;

  /**
   * Loader identifier. Empty string if the request is fetched from worker.
   */
  private final LoaderId loaderId;

  private final String name;

  private final MonotonicTime timestamp;
}
