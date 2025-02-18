package io.github.deripas.chrome.devtools.api.accessibility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
 */
@Generated
public enum AXValueNativeSourceType {
  @JsonProperty("description")
  DESCRIPTION,

  @JsonProperty("figcaption")
  FIGCAPTION,

  @JsonProperty("label")
  LABEL,

  @JsonProperty("labelfor")
  LABELFOR,

  @JsonProperty("labelwrapped")
  LABELWRAPPED,

  @JsonProperty("legend")
  LEGEND,

  @JsonProperty("rubyannotation")
  RUBYANNOTATION,

  @JsonProperty("tablecaption")
  TABLECAPTION,

  @JsonProperty("title")
  TITLE,

  @JsonProperty("other")
  OTHER
}
