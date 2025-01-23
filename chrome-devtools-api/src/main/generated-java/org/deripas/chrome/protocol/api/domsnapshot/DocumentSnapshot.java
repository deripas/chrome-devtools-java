package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Long;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Document snapshot.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DocumentSnapshot {
  /**
   * Document URL that `Document` or `FrameOwner` node points to.
   */
  private final StringIndex documentURL;

  /**
   * Document title.
   */
  private final StringIndex title;

  /**
   * Base URL that `Document` or `FrameOwner` node uses for URL completion.
   */
  private final StringIndex baseURL;

  /**
   * Contains the document's content language.
   */
  private final StringIndex contentLanguage;

  /**
   * Contains the document's character set encoding.
   */
  private final StringIndex encodingName;

  /**
   * `DocumentType` node's publicId.
   */
  private final StringIndex publicId;

  /**
   * `DocumentType` node's systemId.
   */
  private final StringIndex systemId;

  /**
   * Frame ID for frame owner elements and also for the document node.
   */
  private final StringIndex frameId;

  /**
   * A table with dom nodes.
   */
  private final NodeTreeSnapshot nodes;

  /**
   * The nodes in the layout tree.
   */
  private final LayoutTreeSnapshot layout;

  /**
   * The post-layout inline text nodes.
   */
  private final TextBoxSnapshot textBoxes;

  /**
   * Horizontal scroll offset.
   */
  @Nullable
  private final Long scrollOffsetX;

  /**
   * Vertical scroll offset.
   */
  @Nullable
  private final Long scrollOffsetY;

  /**
   * Document content width.
   */
  @Nullable
  private final Long contentWidth;

  /**
   * Document content height.
   */
  @Nullable
  private final Long contentHeight;
}
