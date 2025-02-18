package io.github.deripas.chrome.devtools.api.domsnapshot;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import java.lang.Integer;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Table containing nodes.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodeTreeSnapshot {
  /**
   * Parent node index.
   */
  @Nullable
  private final List<Integer> parentIndex;

  /**
   * `Node`'s nodeType.
   */
  @Nullable
  private final List<Integer> nodeType;

  /**
   * Type of the shadow root the `Node` is in. String values are equal to the `ShadowRootType` enum.
   */
  @Nullable
  private final RareStringData shadowRootType;

  /**
   * `Node`'s nodeName.
   */
  @Nullable
  private final List<StringIndex> nodeName;

  /**
   * `Node`'s nodeValue.
   */
  @Nullable
  private final List<StringIndex> nodeValue;

  /**
   * `Node`'s id, corresponds to DOM.Node.backendNodeId.
   */
  @Nullable
  private final List<BackendNodeId> backendNodeId;

  /**
   * Attributes of an `Element` node. Flatten name, value pairs.
   */
  @Nullable
  private final List<ArrayOfStrings> attributes;

  /**
   * Only set for textarea elements, contains the text value.
   */
  @Nullable
  private final RareStringData textValue;

  /**
   * Only set for input elements, contains the input's associated text value.
   */
  @Nullable
  private final RareStringData inputValue;

  /**
   * Only set for radio and checkbox input elements, indicates if the element has been checked
   */
  @Nullable
  private final RareBooleanData inputChecked;

  /**
   * Only set for option elements, indicates if the element has been selected
   */
  @Nullable
  private final RareBooleanData optionSelected;

  /**
   * The index of the document in the list of the snapshot documents.
   */
  @Nullable
  private final RareIntegerData contentDocumentIndex;

  /**
   * Type of a pseudo element node.
   */
  @Nullable
  private final RareStringData pseudoType;

  /**
   * Pseudo element identifier for this node. Only present if there is a
   * valid pseudoType.
   */
  @Nullable
  private final RareStringData pseudoIdentifier;

  /**
   * Whether this DOM node responds to mouse clicks. This includes nodes that have had click
   * event listeners attached via JavaScript as well as anchor tags that naturally navigate when
   * clicked.
   */
  @Nullable
  private final RareBooleanData isClickable;

  /**
   * The selected url for nodes with a srcset attribute.
   */
  @Nullable
  private final RareStringData currentSourceURL;

  /**
   * The url of the script (if any) that generates this node.
   */
  @Nullable
  private final RareStringData originURL;
}
