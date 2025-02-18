package io.github.deripas.chrome.devtools.api.preload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum RuleSetErrorType {
  @JsonProperty("SourceIsNotJsonObject")
  SOURCE_IS_NOT_JSON_OBJECT,

  @JsonProperty("InvalidRulesSkipped")
  INVALID_RULES_SKIPPED
}
