package io.github.deripas.chrome.devtools.api.dom;

import java.lang.Object;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS Shape Outside details.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ShapeOutsideInfo {
  /**
   * Shape bounds
   */
  private final Quad bounds;

  /**
   * Shape coordinate details
   */
  private final List<Object> shape;

  /**
   * Margin shape bounds
   */
  private final List<Object> marginShape;
}
