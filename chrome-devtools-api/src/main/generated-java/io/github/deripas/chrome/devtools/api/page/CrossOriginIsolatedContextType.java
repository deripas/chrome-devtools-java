package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * Indicates whether the frame is cross-origin isolated and why it is the case.
 */
@Experimental
@Generated
public enum CrossOriginIsolatedContextType {
  @JsonProperty("Isolated")
  ISOLATED,

  @JsonProperty("NotIsolated")
  NOT_ISOLATED,

  @JsonProperty("NotIsolatedFeatureDisabled")
  NOT_ISOLATED_FEATURE_DISABLED
}
