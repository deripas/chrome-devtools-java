package org.deripas.chrome.protocol.api.runtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Represents options for serialization. Overrides `generatePreview` and `returnByValue`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SerializationOptions {
  private final Serialization serialization;

  /**
   * Deep serialization depth. Default is full depth. Respected only in `deep` serialization mode.
   */
  @Nullable
  private final Integer maxDepth;

  /**
   * Embedder-specific parameters. For example if connected to V8 in Chrome these control DOM
   * serialization via `maxNodeDepth: integer` and `includeShadowTree: "none" | "open" | "all"`.
   * Values can be only of type string or integer.
   */
  @Nullable
  private final Map additionalParameters;

  public enum Serialization {
    @JsonProperty("deep")
    DEEP,

    @JsonProperty("json")
    JSON,

    @JsonProperty("idOnly")
    ID_ONLY
  }
}
