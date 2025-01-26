package org.deripas.chrome.protocol.api.heapprofiler.event;

import java.lang.Boolean;
import java.lang.Integer;
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
public class ReportHeapSnapshotProgressEvent {
  public static final EventId<ReportHeapSnapshotProgressEvent> ID = new EventId<>("HeapProfiler.reportHeapSnapshotProgress", ReportHeapSnapshotProgressEvent.class);

  private final Integer done;

  private final Integer total;

  @Nullable
  private final Boolean finished;
}
