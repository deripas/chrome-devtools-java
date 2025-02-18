package io.github.deripas.chrome.devtools.api.layertree;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.dom.Rect;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
