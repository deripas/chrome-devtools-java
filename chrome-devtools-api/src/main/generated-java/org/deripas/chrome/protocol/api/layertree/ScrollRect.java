package org.deripas.chrome.protocol.api.layertree;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.Rect;

/**
 * Rectangle where scrolling happens on the main thread.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScrollRect {
  /**
   * Rectangle itself.
   */
  private final Rect rect;

  /**
   * Reason for rectangle to force scrolling on the main thread
   */
  private final Type type;

  public enum Type {
    @JsonProperty("RepaintsOnScroll")
    REPAINTS_ON_SCROLL,

    @JsonProperty("TouchEventHandler")
    TOUCH_EVENT_HANDLER,

    @JsonProperty("WheelEventHandler")
    WHEEL_EVENT_HANDLER
  }
}
