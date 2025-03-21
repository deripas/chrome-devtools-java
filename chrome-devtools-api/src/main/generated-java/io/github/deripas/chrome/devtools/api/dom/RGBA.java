package io.github.deripas.chrome.devtools.api.dom;

import java.lang.Double;
import java.lang.Integer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A structure holding an RGBA color.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RGBA {
  /**
   * The red component, in the [0-255] range.
   */
  private final Integer r;

  /**
   * The green component, in the [0-255] range.
   */
  private final Integer g;

  /**
   * The blue component, in the [0-255] range.
   */
  private final Integer b;

  /**
   * The alpha component, in the [0-1] range (default: 1).
   */
  @Nullable
  private final Double a;
}
