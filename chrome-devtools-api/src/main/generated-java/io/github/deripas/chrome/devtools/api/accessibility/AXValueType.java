package io.github.deripas.chrome.devtools.api.accessibility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of possible property types.
 */
@Generated
public enum AXValueType {
  @JsonProperty("boolean")
  BOOLEAN,

  @JsonProperty("tristate")
  TRISTATE,

  @JsonProperty("booleanOrUndefined")
  BOOLEAN_OR_UNDEFINED,

  @JsonProperty("idref")
  IDREF,

  @JsonProperty("idrefList")
  IDREF_LIST,

  @JsonProperty("integer")
  INTEGER,

  @JsonProperty("node")
  NODE,

  @JsonProperty("nodeList")
  NODE_LIST,

  @JsonProperty("number")
  NUMBER,

  @JsonProperty("string")
  STRING,

  @JsonProperty("computedString")
  COMPUTED_STRING,

  @JsonProperty("token")
  TOKEN,

  @JsonProperty("tokenList")
  TOKEN_LIST,

  @JsonProperty("domRelation")
  DOM_RELATION,

  @JsonProperty("role")
  ROLE,

  @JsonProperty("internalRole")
  INTERNAL_ROLE,

  @JsonProperty("valueUndefined")
  VALUE_UNDEFINED
}
