package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS style coming from animations with the name of the animation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSAnimationStyle {
  /**
   * The name of the animation.
   */
  @Nullable
  private final String name;

  /**
   * The style coming from the animation.
   */
  private final CSSStyle style;
}
