package org.deripas.chrome.protocol.api.overlay;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.NodeId;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class FlexNodeHighlightConfig {
  /**
   * A descriptor for the highlight appearance of flex containers.
   */
  private final FlexContainerHighlightConfig flexContainerHighlightConfig;

  /**
   * Identifier of the node to highlight.
   */
  private final NodeId nodeId;
}
