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
