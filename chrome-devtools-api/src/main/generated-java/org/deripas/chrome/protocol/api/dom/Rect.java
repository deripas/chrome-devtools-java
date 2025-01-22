package org.deripas.chrome.protocol.api.dom;

import java.lang.Long;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Rectangle.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Rect {
  /**
   * X coordinate
   */
  private final Long x;

  /**
   * Y coordinate
   */
  private final Long y;

  /**
   * Rectangle width
   */
  private final Long width;

  /**
   * Rectangle height
   */
  private final Long height;
}
