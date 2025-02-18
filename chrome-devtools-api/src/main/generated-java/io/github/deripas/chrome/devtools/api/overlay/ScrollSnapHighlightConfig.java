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
public class ScrollSnapHighlightConfig {
  /**
   * A descriptor for the highlight appearance of scroll snap containers.
   */
  private final ScrollSnapContainerHighlightConfig scrollSnapContainerHighlightConfig;

  /**
   * Identifier of the node to highlight.
   */
  private final NodeId nodeId;
}
