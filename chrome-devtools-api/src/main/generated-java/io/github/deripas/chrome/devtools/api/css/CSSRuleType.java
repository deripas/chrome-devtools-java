package io.github.deripas.chrome.devtools.api.css;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Enum indicating the type of a CSS rule, used to represent the order of a style rule's ancestors.
 * This list only contains rule types that are collected during the ancestor rule collection.
 */
@Experimental
@Generated
public enum CSSRuleType {
  @JsonProperty("MediaRule")
  MEDIA_RULE,

  @JsonProperty("SupportsRule")
  SUPPORTS_RULE,

  @JsonProperty("ContainerRule")
  CONTAINER_RULE,

  @JsonProperty("LayerRule")
  LAYER_RULE,

  @JsonProperty("ScopeRule")
  SCOPE_RULE,

  @JsonProperty("StyleRule")
  STYLE_RULE,

  @JsonProperty("StartingStyleRule")
  STARTING_STYLE_RULE
}
