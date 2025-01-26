package org.deripas.chrome.protocol.api.page.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class LoadEventFiredEvent {
  public static final EventId<LoadEventFiredEvent> ID = new EventId<>("Page.loadEventFired", LoadEventFiredEvent.class);

  private final MonotonicTime timestamp;
}
