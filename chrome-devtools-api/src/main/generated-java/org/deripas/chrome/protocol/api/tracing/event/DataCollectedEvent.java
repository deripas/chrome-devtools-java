package org.deripas.chrome.protocol.api.tracing.event;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Contains a bucket of collected trace events. When tracing is stopped collected events will be
 * sent as a sequence of dataCollected events followed by tracingComplete event.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DataCollectedEvent {
  public static final EventId<DataCollectedEvent> ID = new EventId<>("Tracing.dataCollected", DataCollectedEvent.class);

  private final List<Map> value;
}
