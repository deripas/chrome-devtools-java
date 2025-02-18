package io.github.deripas.chrome.devtools.api.memory;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Array of heap profile samples.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SamplingProfile {
  private final List<SamplingProfileNode> samples;

  private final List<Module> modules;
}
