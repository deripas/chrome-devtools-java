package io.github.deripas.chrome.devtools.api.memory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Memory pressure level.
 */
@Generated
public enum PressureLevel {
  @JsonProperty("moderate")
  MODERATE,

  @JsonProperty("critical")
  CRITICAL
}
