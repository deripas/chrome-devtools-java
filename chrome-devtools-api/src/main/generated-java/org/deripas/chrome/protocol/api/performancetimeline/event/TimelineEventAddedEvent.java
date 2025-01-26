package org.deripas.chrome.protocol.api.performancetimeline.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.performancetimeline.TimelineEvent;

/**
 * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TimelineEventAddedEvent {
  public static final EventId<TimelineEventAddedEvent> ID = new EventId<>("PerformanceTimeline.timelineEventAdded", TimelineEventAddedEvent.class);

  private final TimelineEvent event;
}
