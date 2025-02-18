package io.github.deripas.chrome.devtools.api.page;

import java.lang.Double;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Viewport for capturing screenshot.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Viewport {
  /**
   * X offset in device independent pixels (dip).
   */
  private final Double x;

  /**
   * Y offset in device independent pixels (dip).
   */
  private final Double y;

  /**
   * Rectangle width in device independent pixels (dip).
   */
  private final Double width;

  /**
   * Rectangle height in device independent pixels (dip).
   */
  private final Double height;

  /**
   * Page scale factor.
   */
  private final Double scale;
}
