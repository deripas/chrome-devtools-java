package io.github.deripas.chrome.devtools.api.domdebugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * DOM breakpoint type.
 */
@Generated
public enum DOMBreakpointType {
  @JsonProperty("subtree-modified")
  SUBTREE_MODIFIED,

  @JsonProperty("attribute-modified")
  ATTRIBUTE_MODIFIED,

  @JsonProperty("node-removed")
  NODE_REMOVED
}
