package io.github.deripas.chrome.devtools.api.layertree;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
  private final Double offsetX;

  /**
   * Offset from parent layer, Y coordinate.
   */
  private final Double offsetY;

  /**
   * Layer width.
   */
  private final Double width;

  /**
   * Layer height.
   */
  private final Double height;

  /**
   * Transformation matrix for layer, default is identity matrix
   */
  @Nullable
  private final List<Double> transform;

  /**
   * Transform anchor point X, absent if no transform specified
   */
  @Nullable
  private final Double anchorX;

  /**
   * Transform anchor point Y, absent if no transform specified
   */
  @Nullable
  private final Double anchorY;

  /**
   * Transform anchor point Z, absent if no transform specified
   */
  @Nullable
  private final Double anchorZ;

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
