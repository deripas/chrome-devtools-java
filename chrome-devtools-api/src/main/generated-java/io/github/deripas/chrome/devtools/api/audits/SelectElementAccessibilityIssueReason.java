package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum SelectElementAccessibilityIssueReason {
  @JsonProperty("DisallowedSelectChild")
  DISALLOWED_SELECT_CHILD,

  @JsonProperty("DisallowedOptGroupChild")
  DISALLOWED_OPT_GROUP_CHILD,

  @JsonProperty("NonPhrasingContentOptionChild")
  NON_PHRASING_CONTENT_OPTION_CHILD,

  @JsonProperty("InteractiveContentOptionChild")
  INTERACTIVE_CONTENT_OPTION_CHILD,

  @JsonProperty("InteractiveContentLegendChild")
  INTERACTIVE_CONTENT_LEGEND_CHILD
}
