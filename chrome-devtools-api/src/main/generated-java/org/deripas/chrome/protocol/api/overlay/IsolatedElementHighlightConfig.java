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
public class IsolatedElementHighlightConfig {
  /**
   * A descriptor for the highlight appearance of an element in isolation mode.
   */
  private final IsolationModeHighlightConfig isolationModeHighlightConfig;

  /**
   * Identifier of the isolated element to highlight.
   */
  private final NodeId nodeId;
}
