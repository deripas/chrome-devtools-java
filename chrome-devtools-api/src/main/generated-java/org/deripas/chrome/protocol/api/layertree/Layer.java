package org.deripas.chrome.protocol.api.layertree;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

/**
 * Information about a compositing layer.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Layer {
  /**
   * The unique id for this layer.
   */
  private final LayerId layerId;

  /**
   * The id of parent (not present for root).
   */
  @Nullable
  private final LayerId parentLayerId;

  /**
   * The backend id for the node associated with this layer.
   */
  @Nullable
  private final BackendNodeId backendNodeId;

  /**
   * Offset from parent layer, X coordinate.
   */
  private final Long offsetX;

  /**
   * Offset from parent layer, Y coordinate.
   */
  private final Long offsetY;

  /**
   * Layer width.
   */
  private final Long width;

  /**
   * Layer height.
   */
  private final Long height;

  /**
   * Transformation matrix for layer, default is identity matrix
   */
  @Nullable
  private final List<Long> transform;

  /**
   * Transform anchor point X, absent if no transform specified
   */
  @Nullable
  private final Long anchorX;

  /**
   * Transform anchor point Y, absent if no transform specified
   */
  @Nullable
  private final Long anchorY;

  /**
   * Transform anchor point Z, absent if no transform specified
   */
  @Nullable
  private final Long anchorZ;

  /**
   * Indicates how many time this layer has painted.
   */
  private final Integer paintCount;

  /**
   * Indicates whether this layer hosts any content, rather than being used for
   * transform/scrolling purposes only.
   */
  private final Boolean drawsContent;

  /**
   * Set if layer is not visible.
   */
  @Nullable
  private final Boolean invisible;

  /**
   * Rectangles scrolling on main thread only.
   */
  @Nullable
  private final List<ScrollRect> scrollRects;

  /**
   * Sticky position constraint information
   */
  @Nullable
  private final StickyPositionConstraint stickyPositionConstraint;
}
