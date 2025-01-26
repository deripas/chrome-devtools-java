package org.deripas.chrome.protocol.api.heapprofiler.event;

import java.lang.Integer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * If heap objects tracking has been started then backend may send update for one or more fragments
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class HeapStatsUpdateEvent {
  public static final EventId<HeapStatsUpdateEvent> ID = new EventId<>("HeapProfiler.heapStatsUpdate", HeapStatsUpdateEvent.class);

  /**
   * An array of triplets. Each triplet describes a fragment. The first integer is the fragment
   * index, the second integer is a total count of objects for the fragment, the third integer is
   * a total size of the objects for the fragment.
   */
  private final List<Integer> statsUpdate;
}
