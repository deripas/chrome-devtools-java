package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Reason for a permissions policy feature to be disabled.
 */
@Experimental
@Generated
public enum PermissionsPolicyBlockReason {
  @JsonProperty("Header")
  HEADER,

  @JsonProperty("IframeAttribute")
  IFRAME_ATTRIBUTE,

  @JsonProperty("InFencedFrameTree")
  IN_FENCED_FRAME_TREE,

  @JsonProperty("InIsolatedApp")
  IN_ISOLATED_APP
}
