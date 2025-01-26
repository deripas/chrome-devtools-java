package org.deripas.chrome.protocol.api.tracing.event;

import java.lang.Long;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class BufferUsageEvent {
  public static final EventId<BufferUsageEvent> ID = new EventId<>("Tracing.bufferUsage", BufferUsageEvent.class);

  /**
   * A number in range [0..1] that indicates the used size of event buffer as a fraction of its
   * total size.
   */
  @Nullable
  private final Long percentFull;

  /**
   * An approximate number of events in the trace log.
   */
  @Nullable
  private final Long eventCount;

  /**
   * A number in range [0..1] that indicates the used size of event buffer as a fraction of its
   * total size.
   */
  @Nullable
  private final Long value;
}
