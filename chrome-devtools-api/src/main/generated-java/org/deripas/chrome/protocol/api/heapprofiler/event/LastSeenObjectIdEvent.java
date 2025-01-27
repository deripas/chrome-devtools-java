package org.deripas.chrome.protocol.api.heapprofiler.event;

import java.lang.Double;
import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * If heap objects tracking has been started then backend regularly sends a current value for last
 * seen object id and corresponding timestamp. If the were changes in the heap since last event
 * then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LastSeenObjectIdEvent {
  public static final EventId<LastSeenObjectIdEvent> ID = new EventId<>("HeapProfiler.lastSeenObjectId", LastSeenObjectIdEvent.class);

  private final Integer lastSeenObjectId;

  private final Double timestamp;
}
