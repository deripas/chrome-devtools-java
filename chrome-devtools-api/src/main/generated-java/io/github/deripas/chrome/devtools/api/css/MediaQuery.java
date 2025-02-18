package io.github.deripas.chrome.devtools.api.css;

import java.lang.Boolean;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Media query descriptor.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class MediaQuery {
  /**
   * Array of media query expressions.
   */
  private final List<MediaQueryExpression> expressions;

  /**
   * Whether the media query condition is satisfied.
   */
  private final Boolean active;
}
