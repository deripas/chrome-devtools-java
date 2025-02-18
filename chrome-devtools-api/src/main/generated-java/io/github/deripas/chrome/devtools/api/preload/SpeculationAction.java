package io.github.deripas.chrome.devtools.api.preload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * The type of preloading attempted. It corresponds to
 * mojom::SpeculationAction (although PrefetchWithSubresources is omitted as it
 * isn't being used by clients).
 */
@Generated
public enum SpeculationAction {
  @JsonProperty("Prefetch")
  PREFETCH,

  @JsonProperty("Prerender")
  PRERENDER
}
