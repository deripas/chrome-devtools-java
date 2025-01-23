package org.deripas.chrome.protocol.api.heapprofiler;

import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.CallFrame;

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SamplingHeapProfileNode {
  /**
   * Function location.
   */
  private final CallFrame callFrame;

  /**
   * Allocations size in bytes for the node excluding children.
   */
  private final Long selfSize;

  /**
   * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.
   */
  private final Integer id;

  /**
   * Child nodes.
   */
  private final List<SamplingHeapProfileNode> children;
}
