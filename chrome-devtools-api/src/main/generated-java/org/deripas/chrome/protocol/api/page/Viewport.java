package org.deripas.chrome.protocol.api.page;

import java.lang.Long;
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
  private final Long x;

  /**
   * Y offset in device independent pixels (dip).
   */
  private final Long y;

  /**
   * Rectangle width in device independent pixels (dip).
   */
  private final Long width;

  /**
   * Rectangle height in device independent pixels (dip).
   */
  private final Long height;

  /**
   * Page scale factor.
   */
  private final Long scale;
}
