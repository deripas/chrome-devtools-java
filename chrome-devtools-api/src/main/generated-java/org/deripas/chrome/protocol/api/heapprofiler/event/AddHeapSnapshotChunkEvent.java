package org.deripas.chrome.protocol.api.heapprofiler.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class AddHeapSnapshotChunkEvent {
  public static final EventId<AddHeapSnapshotChunkEvent> ID = new EventId<>("HeapProfiler.addHeapSnapshotChunk", AddHeapSnapshotChunkEvent.class);

  private final String chunk;
}
