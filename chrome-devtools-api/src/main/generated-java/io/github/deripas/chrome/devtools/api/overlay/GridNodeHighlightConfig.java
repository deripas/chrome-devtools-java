package io.github.deripas.chrome.devtools.api.overlay;

import io.github.deripas.chrome.devtools.api.dom.NodeId;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Configurations for Persistent Grid Highlight
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class GridNodeHighlightConfig {
  /**
   * A descriptor for the highlight appearance.
   */
  private final GridHighlightConfig gridHighlightConfig;

  /**
   * Identifier of the node to highlight.
   */
  private final NodeId nodeId;
}
