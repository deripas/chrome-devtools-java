package org.deripas.chrome.protocol.api.memory;

import java.lang.Double;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Heap profile sample.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SamplingProfileNode {
  /**
   * Size of the sampled allocation.
   */
  private final Double size;

  /**
   * Total bytes attributed to this sample.
   */
  private final Double total;

  /**
   * Execution stack at the point of allocation.
   */
  private final List<String> stack;
}
