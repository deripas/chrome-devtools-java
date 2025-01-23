package org.deripas.chrome.protocol.api.overlay;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.NodeId;

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
