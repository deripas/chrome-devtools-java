package io.github.deripas.chrome.devtools.api.preload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Corresponds to mojom::SpeculationTargetHint.
 * See https://github.com/WICG/nav-speculation/blob/main/triggers.md#window-name-targeting-hints
 */
@Generated
public enum SpeculationTargetHint {
  @JsonProperty("Blank")
  BLANK,

  @JsonProperty("Self")
  SELF
}
