package org.deripas.chrome.protocol.api.autofill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Specified whether a filled field was done so by using the html autocomplete attribute or autofill heuristics.
 */
@Generated
public enum FillingStrategy {
  @JsonProperty("autocompleteAttribute")
  AUTOCOMPLETE_ATTRIBUTE,

  @JsonProperty("autofillInferred")
  AUTOFILL_INFERRED
}
