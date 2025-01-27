package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.dom.PseudoType;
import org.deripas.chrome.protocol.api.dom.ShadowRootType;
import org.deripas.chrome.protocol.api.domdebugger.EventListener;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * A Node in the DOM tree.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DOMNode {
  /**
   * `Node`'s nodeType.
   */
  private final Integer nodeType;

  /**
   * `Node`'s nodeName.
   */
  private final String nodeName;

  /**
   * `Node`'s nodeValue.
   */
  private final String nodeValue;

  /**
   * Only set for textarea elements, contains the text value.
   */
  @Nullable
  private final String textValue;

  /**
   * Only set for input elements, contains the input's associated text value.
   */
  @Nullable
  private final String inputValue;

  /**
   * Only set for radio and checkbox input elements, indicates if the element has been checked
   */
  @Nullable
  private final Boolean inputChecked;

  /**
   * Only set for option elements, indicates if the element has been selected
   */
  @Nullable
  private final Boolean optionSelected;

  /**
   * `Node`'s id, corresponds to DOM.Node.backendNodeId.
   */
  private final BackendNodeId backendNodeId;

  /**
   * The indexes of the node's child nodes in the `domNodes` array returned by `getSnapshot`, if
   * any.
   */
  @Nullable
  private final List<Integer> childNodeIndexes;

  /**
   * Attributes of an `Element` node.
   */
  @Nullable
  private final List<NameValue> attributes;

  /**
   * Indexes of pseudo elements associated with this node in the `domNodes` array returned by
   * `getSnapshot`, if any.
   */
  @Nullable
  private final List<Integer> pseudoElementIndexes;

  /**
   * The index of the node's related layout tree node in the `layoutTreeNodes` array returned by
   * `getSnapshot`, if any.
   */
  @Nullable
  private final Integer layoutNodeIndex;

  /**
   * Document URL that `Document` or `FrameOwner` node points to.
   */
  @Nullable
  private final String documentURL;

  /**
   * Base URL that `Document` or `FrameOwner` node uses for URL completion.
   */
  @Nullable
  private final String baseURL;

  /**
   * Only set for documents, contains the document's content language.
   */
  @Nullable
  private final String contentLanguage;

  /**
   * Only set for documents, contains the document's character set encoding.
   */
  @Nullable
  private final String documentEncoding;

  /**
   * `DocumentType` node's publicId.
   */
  @Nullable
  private final String publicId;

  /**
   * `DocumentType` node's systemId.
   */
  @Nullable
  private final String systemId;

  /**
   * Frame ID for frame owner elements and also for the document node.
   */
  @Nullable
  private final FrameId frameId;

  /**
   * The index of a frame owner element's content document in the `domNodes` array returned by
   * `getSnapshot`, if any.
   */
  @Nullable
  private final Integer contentDocumentIndex;

  /**
   * Type of a pseudo element node.
   */
  @Nullable
  private final PseudoType pseudoType;

  /**
   * Shadow root type.
   */
  @Nullable
  private final ShadowRootType shadowRootType;

  /**
   * Whether this DOM node responds to mouse clicks. This includes nodes that have had click
   * event listeners attached via JavaScript as well as anchor tags that naturally navigate when
   * clicked.
   */
  @Nullable
  private final Boolean isClickable;

  /**
   * Details of the node's event listeners, if any.
   */
  @Nullable
  private final List<EventListener> eventListeners;

  /**
   * The selected url for nodes with a srcset attribute.
   */
  @Nullable
  private final String currentSourceURL;

  /**
   * The url of the script (if any) that generates this node.
   */
  @Nullable
  private final String originURL;

  /**
   * Scroll offsets, set when this node is a Document.
   */
  @Nullable
  private final Double scrollOffsetX;

  @Nullable
  private final Double scrollOffsetY;
}
