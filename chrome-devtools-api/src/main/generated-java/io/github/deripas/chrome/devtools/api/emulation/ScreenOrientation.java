package io.github.deripas.chrome.devtools.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Screen orientation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScreenOrientation {
  /**
   * Orientation type.
   */
  private final Type type;

  /**
   * Orientation angle.
   */
  private final Integer angle;

  public enum Type {
    @JsonProperty("portraitPrimary")
    PORTRAIT_PRIMARY,

    @JsonProperty("portraitSecondary")
    PORTRAIT_SECONDARY,

    @JsonProperty("landscapePrimary")
    LANDSCAPE_PRIMARY,

    @JsonProperty("landscapeSecondary")
    LANDSCAPE_SECONDARY
  }
}
