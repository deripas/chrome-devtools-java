package io.github.deripas.chrome.devtools.api.accessibility;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import java.lang.Boolean;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A node in the accessibility tree.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AXNode {
  /**
   * Unique identifier for this node.
   */
  private final AXNodeId nodeId;

  /**
   * Whether this node is ignored for accessibility
   */
  private final Boolean ignored;

  /**
   * Collection of reasons why this node is hidden.
   */
  @Nullable
  private final List<AXProperty> ignoredReasons;

  /**
   * This `Node`'s role, whether explicit or implicit.
   */
  @Nullable
  private final AXValue role;

  /**
   * This `Node`'s Chrome raw role.
   */
  @Nullable
  private final AXValue chromeRole;

  /**
   * The accessible name for this `Node`.
   */
  @Nullable
  private final AXValue name;

  /**
   * The accessible description for this `Node`.
   */
  @Nullable
  private final AXValue description;

  /**
   * The value for this `Node`.
   */
  @Nullable
  private final AXValue value;

  /**
   * All other properties
   */
  @Nullable
  private final List<AXProperty> properties;

  /**
   * ID for this node's parent.
   */
  @Nullable
  private final AXNodeId parentId;

  /**
   * IDs for each of this node's child nodes.
   */
  @Nullable
  private final List<AXNodeId> childIds;

  /**
   * The backend ID for the associated DOM node, if any.
   */
  @Nullable
  private final BackendNodeId backendDOMNodeId;

  /**
   * The frame ID for the frame associated with this nodes document.
   */
  @Nullable
  private final FrameId frameId;
}
