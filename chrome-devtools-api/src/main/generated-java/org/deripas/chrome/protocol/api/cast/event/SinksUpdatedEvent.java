package org.deripas.chrome.protocol.api.cast.event;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.cast.Sink;

/**
 * This is fired whenever the list of available sinks changes. A sink is a
 * device or a software surface that you can cast to.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SinksUpdatedEvent {
  public static final EventId<SinksUpdatedEvent> ID = new EventId<>("Cast.sinksUpdated", SinksUpdatedEvent.class);

  private final List<Sink> sinks;
}
