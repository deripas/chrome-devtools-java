package io.github.deripas.chrome.devtools.api.dom;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A structure to hold the top-level node of a detached tree and an array of its retained descendants.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DetachedElementInfo {
  private final Node treeNode;

  private final List<NodeId> retainedNodeIds;
}
