package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Table of details of an element in the DOM tree with a LayoutObject.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayoutTreeSnapshot {
  /**
   * Index of the corresponding node in the `NodeTreeSnapshot` array returned by `captureSnapshot`.
   */
  private final List<Integer> nodeIndex;

  /**
   * Array of indexes specifying computed style strings, filtered according to the `computedStyles` parameter passed to `captureSnapshot`.
   */
  private final List<ArrayOfStrings> styles;

  /**
   * The absolute position bounding box.
   */
  private final List<Rectangle> bounds;

  /**
   * Contents of the LayoutText, if any.
   */
  private final List<StringIndex> text;

  /**
   * Stacking context information.
   */
  private final RareBooleanData stackingContexts;

  /**
   * Global paint order index, which is determined by the stacking order of the nodes. Nodes
   * that are painted together will have the same index. Only provided if includePaintOrder in
   * captureSnapshot was true.
   */
  @Nullable
  private final List<Integer> paintOrders;

  /**
   * The offset rect of nodes. Only available when includeDOMRects is set to true
   */
  @Nullable
  private final List<Rectangle> offsetRects;

  /**
   * The scroll rect of nodes. Only available when includeDOMRects is set to true
   */
  @Nullable
  private final List<Rectangle> scrollRects;

  /**
   * The client rect of nodes. Only available when includeDOMRects is set to true
   */
  @Nullable
  private final List<Rectangle> clientRects;

  /**
   * The list of background colors that are blended with colors of overlapping elements.
   */
  @Nullable
  @Experimental
  private final List<StringIndex> blendedBackgroundColors;

  /**
   * The list of computed text opacities.
   */
  @Nullable
  @Experimental
  private final List<Long> textColorOpacities;
}
