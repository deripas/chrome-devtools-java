package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum PropertyRuleIssueReason {
  @JsonProperty("InvalidSyntax")
  INVALID_SYNTAX,

  @JsonProperty("InvalidInitialValue")
  INVALID_INITIAL_VALUE,

  @JsonProperty("InvalidInherits")
  INVALID_INHERITS,

  @JsonProperty("InvalidName")
  INVALID_NAME
}
