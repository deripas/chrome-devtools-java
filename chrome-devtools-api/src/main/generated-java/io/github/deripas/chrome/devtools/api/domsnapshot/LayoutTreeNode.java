package io.github.deripas.chrome.devtools.api.domsnapshot;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.Rect;

/**
 * Details of an element in the DOM tree with a LayoutObject.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayoutTreeNode {
  /**
   * The index of the related DOM node in the `domNodes` array returned by `getSnapshot`.
   */
  private final Integer domNodeIndex;

  /**
   * The bounding box in document coordinates. Note that scroll offset of the document is ignored.
   */
  private final Rect boundingBox;

  /**
   * Contents of the LayoutText, if any.
   */
  @Nullable
  private final String layoutText;

  /**
   * The post-layout inline text nodes, if any.
   */
  @Nullable
  private final List<InlineTextBox> inlineTextNodes;

  /**
   * Index into the `computedStyles` array returned by `getSnapshot`.
   */
  @Nullable
  private final Integer styleIndex;

  /**
   * Global paint order index, which is determined by the stacking order of the nodes. Nodes
   * that are painted together will have the same index. Only provided if includePaintOrder in
   * getSnapshot was true.
   */
  @Nullable
  private final Integer paintOrder;

  /**
   * Set to true to indicate the element begins a new stacking context.
   */
  @Nullable
  private final Boolean isStackingContext;
}
