package io.github.deripas.chrome.devtools.api.emulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class DisplayFeature {
  /**
   * Orientation of a display feature in relation to screen
   */
  private final Orientation orientation;

  /**
   * The offset from the screen origin in either the x (for vertical
   * orientation) or y (for horizontal orientation) direction.
   */
  private final Integer offset;

  /**
   * A display feature may mask content such that it is not physically
   * displayed - this length along with the offset describes this area.
   * A display feature that only splits content will have a 0 mask_length.
   */
  private final Integer maskLength;

  public enum Orientation {
    @JsonProperty("vertical")
    VERTICAL,

    @JsonProperty("horizontal")
    HORIZONTAL
  }
}
