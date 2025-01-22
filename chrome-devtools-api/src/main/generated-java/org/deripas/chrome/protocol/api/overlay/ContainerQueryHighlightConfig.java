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
