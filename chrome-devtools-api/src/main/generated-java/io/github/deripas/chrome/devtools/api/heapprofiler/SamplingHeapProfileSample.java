package io.github.deripas.chrome.devtools.api.heapprofiler;

import java.lang.Double;
import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A single sample from a sampling profile.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SamplingHeapProfileSample {
  /**
   * Allocation size in bytes attributed to the sample.
   */
  private final Double size;

  /**
   * Id of the corresponding profile tree node.
   */
  private final Integer nodeId;

  /**
   * Time-ordered sample ordinal number. It is unique across all profiles retrieved
   * between startSampling and stopSampling.
   */
  private final Double ordinal;
}
