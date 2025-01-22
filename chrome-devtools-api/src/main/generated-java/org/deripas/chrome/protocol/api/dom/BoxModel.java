package org.deripas.chrome.protocol.api.dom;

import java.lang.Integer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Box model.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BoxModel {
  /**
   * Content box
   */
  private final Quad content;

  /**
   * Padding box
   */
  private final Quad padding;

  /**
   * Border box
   */
  private final Quad border;

  /**
   * Margin box
   */
  private final Quad margin;

  /**
   * Node width
   */
  private final Integer width;

  /**
   * Node height
   */
  private final Integer height;

  /**
   * Shape outside coordinates
   */
  @Nullable
  private final ShapeOutsideInfo shapeOutside;
}
