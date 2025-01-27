package org.deripas.chrome.protocol.api.dom;

import java.lang.Double;
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
  private final Double x;

  /**
   * Y coordinate
   */
  private final Double y;

  /**
   * Rectangle width
   */
  private final Double width;

  /**
   * Rectangle height
   */
  private final Double height;
}
