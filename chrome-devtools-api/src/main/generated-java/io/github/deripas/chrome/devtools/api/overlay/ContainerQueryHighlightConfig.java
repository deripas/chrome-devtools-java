package io.github.deripas.chrome.devtools.api.overlay;

import io.github.deripas.chrome.devtools.api.dom.NodeId;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContainerQueryHighlightConfig {
  /**
   * A descriptor for the highlight appearance of container query containers.
   */
  private final ContainerQueryContainerHighlightConfig containerQueryContainerHighlightConfig;

  /**
   * Identifier of the container node to highlight.
   */
  private final NodeId nodeId;
}
