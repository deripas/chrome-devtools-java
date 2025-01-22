package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Transition type.
 */
@Generated
public enum TransitionType {
  @JsonProperty("link")
  LINK,

  @JsonProperty("typed")
  TYPED,

  @JsonProperty("address_bar")
  ADDRESS_BAR,

  @JsonProperty("auto_bookmark")
  AUTO_BOOKMARK,

  @JsonProperty("auto_subframe")
  AUTO_SUBFRAME,

  @JsonProperty("manual_subframe")
  MANUAL_SUBFRAME,

  @JsonProperty("generated")
  GENERATED,

  @JsonProperty("auto_toplevel")
  AUTO_TOPLEVEL,

  @JsonProperty("form_submit")
  FORM_SUBMIT,

  @JsonProperty("reload")
  RELOAD,

  @JsonProperty("keyword")
  KEYWORD,

  @JsonProperty("keyword_generated")
  KEYWORD_GENERATED,

  @JsonProperty("other")
  OTHER
}
