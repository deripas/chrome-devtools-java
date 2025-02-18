package io.github.deripas.chrome.devtools.api.heapprofiler;

import io.github.deripas.chrome.devtools.api.runtime.CallFrame;
import java.lang.Double;
import java.lang.Integer;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
  private final Double selfSize;

  /**
   * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.
   */
  private final Integer id;

  /**
   * Child nodes.
   */
  private final List<SamplingHeapProfileNode> children;
}
