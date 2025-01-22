package org.deripas.chrome.protocol.api.performancetimeline;

import java.lang.Long;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;
import org.deripas.chrome.protocol.api.page.FrameId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class TimelineEvent {
  /**
   * Identifies the frame that this event is related to. Empty for non-frame targets.
   */
  private final FrameId frameId;

  /**
   * The event type, as specified in https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype
   * This determines which of the optional "details" fields is present.
   */
  private final String type;

  /**
   * Name may be empty depending on the type.
   */
  private final String name;

  /**
   * Time in seconds since Epoch, monotonically increasing within document lifetime.
   */
  private final TimeSinceEpoch time;

  /**
   * Event duration, if applicable.
   */
  @Nullable
  private final Long duration;

  @Nullable
  private final LargestContentfulPaint lcpDetails;

  @Nullable
  private final LayoutShift layoutShiftDetails;
}
