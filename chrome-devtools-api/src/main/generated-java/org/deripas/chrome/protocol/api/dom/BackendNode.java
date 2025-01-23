package org.deripas.chrome.protocol.api.dom;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Backend node with a friendly name.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BackendNode {
  /**
   * `Node`'s nodeType.
   */
  private final Integer nodeType;

  /**
   * `Node`'s nodeName.
   */
  private final String nodeName;

  private final BackendNodeId backendNodeId;
}
