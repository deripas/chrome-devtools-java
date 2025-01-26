package org.deripas.chrome.protocol.api.page.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when frame has been detached from its parent.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameDetachedEvent {
  public static final EventId<FrameDetachedEvent> ID = new EventId<>("Page.frameDetached", FrameDetachedEvent.class);

  /**
   * Id of the frame that has been detached.
   */
  private final FrameId frameId;

  @Experimental
  private final Reason reason;

  public enum Reason {
    @JsonProperty("remove")
    REMOVE,

    @JsonProperty("swap")
    SWAP
  }
}
