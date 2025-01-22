package org.deripas.chrome.protocol.api.overlay;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.RGBA;

/**
 * Style information for drawing a line.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LineStyle {
  /**
   * The color of the line (default: transparent)
   */
  @Nullable
  private final RGBA color;

  /**
   * The line pattern (default: solid)
   */
  @Nullable
  private final Pattern pattern;

  public enum Pattern {
    @JsonProperty("dashed")
    DASHED,

    @JsonProperty("dotted")
    DOTTED
  }
}
