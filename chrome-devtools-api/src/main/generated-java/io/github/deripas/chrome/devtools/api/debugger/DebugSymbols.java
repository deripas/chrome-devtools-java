package io.github.deripas.chrome.devtools.api.debugger;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Debug symbols available for a wasm script.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DebugSymbols {
  /**
   * Type of the debug symbols.
   */
  private final Type type;

  /**
   * URL of the external symbol source.
   */
  @Nullable
  private final String externalURL;

  public enum Type {
    @JsonProperty("SourceMap")
    SOURCE_MAP,

    @JsonProperty("EmbeddedDWARF")
    EMBEDDED_D_W_A_R_F,

    @JsonProperty("ExternalDWARF")
    EXTERNAL_D_W_A_R_F
  }
}
