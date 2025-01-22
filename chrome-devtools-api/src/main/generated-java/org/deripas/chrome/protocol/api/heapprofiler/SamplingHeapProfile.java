package org.deripas.chrome.protocol.api.heapprofiler;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Sampling profile.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SamplingHeapProfile {
  private final SamplingHeapProfileNode head;

  private final List<SamplingHeapProfileSample> samples;
}
