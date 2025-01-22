package org.deripas.chrome.protocol.api.dom;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes.
 * DOMNode is a base node mirror type.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Node {
  /**
   * Node identifier that is passed into the rest of the DOM messages as the `nodeId`. Backend
   * will only push node with given `id` once. It is aware of all requested nodes and will only
   * fire DOM events for nodes known to the client.
   */
  private final NodeId nodeId;

  /**
   * The id of the parent node if any.
   */
  @Nullable
  private final NodeId parentId;

  /**
   * The BackendNodeId for this node.
   */
  private final BackendNodeId backendNodeId;

  /**
   * `Node`'s nodeType.
   */
  private final Integer nodeType;

  /**
   * `Node`'s nodeName.
   */
  private final String nodeName;

  /**
   * `Node`'s localName.
   */
  private final String localName;

  /**
   * `Node`'s nodeValue.
   */
  private final String nodeValue;

  /**
   * Child count for `Container` nodes.
   */
  @Nullable
  private final Integer childNodeCount;

  /**
   * Child nodes of this node when requested with children.
   */
  @Nullable
  private final List<Node> children;

  /**
   * Attributes of the `Element` node in the form of flat array `[name1, value1, name2, value2]`.
   */
  @Nullable
  private final List<String> attributes;

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
   * `DocumentType`'s publicId.
   */
  @Nullable
  private final String publicId;

  /**
   * `DocumentType`'s systemId.
   */
  @Nullable
  private final String systemId;

  /**
   * `DocumentType`'s internalSubset.
   */
  @Nullable
  private final String internalSubset;

  /**
   * `Document`'s XML version in case of XML documents.
   */
  @Nullable
  private final String xmlVersion;

  /**
   * `Attr`'s name.
   */
  @Nullable
  private final String name;

  /**
   * `Attr`'s value.
   */
  @Nullable
  private final String value;

  /**
   * Pseudo element type for this node.
   */
  @Nullable
  private final PseudoType pseudoType;

  /**
   * Pseudo element identifier for this node. Only present if there is a
   * valid pseudoType.
   */
  @Nullable
  private final String pseudoIdentifier;

  /**
   * Shadow root type.
   */
  @Nullable
  private final ShadowRootType shadowRootType;

  /**
   * Frame ID for frame owner elements.
   */
  @Nullable
  private final FrameId frameId;

  /**
   * Content document for frame owner elements.
   */
  @Nullable
  private final Node contentDocument;

  /**
   * Shadow root list for given element host.
   */
  @Nullable
  private final List<Node> shadowRoots;

  /**
   * Content document fragment for template elements.
   */
  @Nullable
  private final Node templateContent;

  /**
   * Pseudo elements associated with this node.
   */
  @Nullable
  private final List<Node> pseudoElements;

  /**
   * Deprecated, as the HTML Imports API has been removed (crbug.com/937746).
   * This property used to return the imported document for the HTMLImport links.
   * The property is always undefined now.
   */
  @Nullable
  @Deprecated
  private final Node importedDocument;

  /**
   * Distributed nodes for given insertion point.
   */
  @Nullable
  private final List<BackendNode> distributedNodes;

  /**
   * Whether the node is SVG.
   */
  @Nullable
  private final Boolean isSVG;

  @Nullable
  private final CompatibilityMode compatibilityMode;

  @Nullable
  private final BackendNode assignedSlot;

  @Nullable
  @Experimental
  private final Boolean isScrollable;
}
