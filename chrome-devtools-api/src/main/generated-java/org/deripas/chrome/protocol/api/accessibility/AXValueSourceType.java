package org.deripas.chrome.protocol.api.accessibility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of possible property sources.
 */
@Generated
public enum AXValueSourceType {
  @JsonProperty("attribute")
  ATTRIBUTE,

  @JsonProperty("implicit")
  IMPLICIT,

  @JsonProperty("style")
  STYLE,

  @JsonProperty("contents")
  CONTENTS,

  @JsonProperty("placeholder")
  PLACEHOLDER,

  @JsonProperty("relatedElement")
  RELATED_ELEMENT
}
