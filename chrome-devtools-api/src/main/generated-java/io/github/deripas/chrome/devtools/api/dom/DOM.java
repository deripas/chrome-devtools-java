package io.github.deripas.chrome.devtools.api.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import io.github.deripas.chrome.devtools.api.runtime.ExecutionContextId;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObjectId;
import io.github.deripas.chrome.devtools.api.runtime.StackTrace;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object
 * that has an `id`. This `id` can be used to get additional information on the Node, resolve it into
 * the JavaScript object wrapper, etc. It is important that client receives DOM events only for the
 * nodes that are known to the client. Backend keeps track of the nodes that were sent to the client
 * and never sends the same node twice. It is client's responsibility to collect information about
 * the nodes that were sent to the client. Note that `iframe` owner elements will return
 * corresponding document elements as their child nodes.
 */
@Generated
public interface DOM {
  /**
   * Collects class names for the node with given id and all of it's child nodes.
   */
  CompletableFuture<CollectClassNamesFromSubtreeResponse> collectClassNamesFromSubtree(
      CollectClassNamesFromSubtreeRequest request);

  /**
   * Creates a deep copy of the specified node and places it into the target container before the
   * given anchor.
   */
  CompletableFuture<CopyToResponse> copyTo(CopyToRequest request);

  /**
   * Describes node given its id, does not require domain to be enabled. Does not start tracking any
   * objects, can be used for automation.
   */
  CompletableFuture<DescribeNodeResponse> describeNode(DescribeNodeRequest request);

  /**
   * Scrolls the specified rect of the given node into view if not already visible.
   * Note: exactly one between nodeId, backendNodeId and objectId should be passed
   * to identify the node.
   */
  CompletableFuture<Void> scrollIntoViewIfNeeded(ScrollIntoViewIfNeededRequest request);

  /**
   * Disables DOM agent for the given page.
   */
  CompletableFuture<Void> disable();

  /**
   * Discards search results from the session with the given id. `getSearchResults` should no longer
   * be called for that search.
   */
  CompletableFuture<Void> discardSearchResults(DiscardSearchResultsRequest request);

  /**
   * Enables DOM agent for the given page.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Focuses the given element.
   */
  CompletableFuture<Void> focus(FocusRequest request);

  /**
   * Returns attributes for the specified node.
   */
  CompletableFuture<GetAttributesResponse> getAttributes(GetAttributesRequest request);

  /**
   * Returns boxes for the given node.
   */
  CompletableFuture<GetBoxModelResponse> getBoxModel(GetBoxModelRequest request);

  /**
   * Returns quads that describe node position on the page. This method
   * might return multiple quads for inline nodes.
   */
  CompletableFuture<GetContentQuadsResponse> getContentQuads(GetContentQuadsRequest request);

  /**
   * Returns the root DOM node (and optionally the subtree) to the caller.
   * Implicitly enables the DOM domain events for the current target.
   */
  CompletableFuture<GetDocumentResponse> getDocument(GetDocumentRequest request);

  /**
   * Returns the root DOM node (and optionally the subtree) to the caller.
   * Deprecated, as it is not designed to work well with the rest of the DOM agent.
   * Use DOMSnapshot.captureSnapshot instead.
   */
  @Deprecated
  CompletableFuture<GetFlattenedDocumentResponse> getFlattenedDocument(
      GetFlattenedDocumentRequest request);

  /**
   * Finds nodes with a given computed style in a subtree.
   */
  CompletableFuture<GetNodesForSubtreeByStyleResponse> getNodesForSubtreeByStyle(
      GetNodesForSubtreeByStyleRequest request);

  /**
   * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is
   * either returned or not.
   */
  CompletableFuture<GetNodeForLocationResponse> getNodeForLocation(
      GetNodeForLocationRequest request);

  /**
   * Returns node's HTML markup.
   */
  CompletableFuture<GetOuterHTMLResponse> getOuterHTML(GetOuterHTMLRequest request);

  /**
   * Returns the id of the nearest ancestor that is a relayout boundary.
   */
  CompletableFuture<GetRelayoutBoundaryResponse> getRelayoutBoundary(
      GetRelayoutBoundaryRequest request);

  /**
   * Returns search results from given `fromIndex` to given `toIndex` from the search with the given
   * identifier.
   */
  CompletableFuture<GetSearchResultsResponse> getSearchResults(GetSearchResultsRequest request);

  /**
   * Hides any highlight.
   */
  CompletableFuture<Void> hideHighlight();

  /**
   * Highlights DOM node.
   */
  CompletableFuture<Void> highlightNode();

  /**
   * Highlights given rectangle.
   */
  CompletableFuture<Void> highlightRect();

  /**
   * Marks last undoable state.
   */
  CompletableFuture<Void> markUndoableState();

  /**
   * Moves node into the new container, places it before the given anchor.
   */
  CompletableFuture<MoveToResponse> moveTo(MoveToRequest request);

  /**
   * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or
   * `cancelSearch` to end this search session.
   */
  CompletableFuture<PerformSearchResponse> performSearch(PerformSearchRequest request);

  /**
   * Requests that the node is sent to the caller given its path. // FIXME, use XPath
   */
  CompletableFuture<PushNodeByPathToFrontendResponse> pushNodeByPathToFrontend(
      PushNodeByPathToFrontendRequest request);

  /**
   * Requests that a batch of nodes is sent to the caller given their backend node ids.
   */
  CompletableFuture<PushNodesByBackendIdsToFrontendResponse> pushNodesByBackendIdsToFrontend(
      PushNodesByBackendIdsToFrontendRequest request);

  /**
   * Executes `querySelector` on a given node.
   */
  CompletableFuture<QuerySelectorResponse> querySelector(QuerySelectorRequest request);

  /**
   * Executes `querySelectorAll` on a given node.
   */
  CompletableFuture<QuerySelectorAllResponse> querySelectorAll(QuerySelectorAllRequest request);

  /**
   * Returns NodeIds of current top layer elements.
   * Top layer is rendered closest to the user within a viewport, therefore its elements always
   * appear on top of all other content.
   */
  CompletableFuture<GetTopLayerElementsResponse> getTopLayerElements();

  /**
   * Returns the NodeId of the matched element according to certain relations.
   */
  CompletableFuture<GetElementByRelationResponse> getElementByRelation(
      GetElementByRelationRequest request);

  /**
   * Re-does the last undone action.
   */
  CompletableFuture<Void> redo();

  /**
   * Removes attribute with given name from an element with given id.
   */
  CompletableFuture<Void> removeAttribute(RemoveAttributeRequest request);

  /**
   * Removes node with given id.
   */
  CompletableFuture<Void> removeNode(RemoveNodeRequest request);

  /**
   * Requests that children of the node with given id are returned to the caller in form of
   * `setChildNodes` events where not only immediate children are retrieved, but all children down to
   * the specified depth.
   */
  CompletableFuture<Void> requestChildNodes(RequestChildNodesRequest request);

  /**
   * Requests that the node is sent to the caller given the JavaScript node object reference. All
   * nodes that form the path from the node to the root are also sent to the client as a series of
   * `setChildNodes` notifications.
   */
  CompletableFuture<RequestNodeResponse> requestNode(RequestNodeRequest request);

  /**
   * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
   */
  CompletableFuture<ResolveNodeResponse> resolveNode(ResolveNodeRequest request);

  /**
   * Sets attribute for an element with given id.
   */
  CompletableFuture<Void> setAttributeValue(SetAttributeValueRequest request);

  /**
   * Sets attributes on element with given id. This method is useful when user edits some existing
   * attribute value and types in several attribute name/value pairs.
   */
  CompletableFuture<Void> setAttributesAsText(SetAttributesAsTextRequest request);

  /**
   * Sets files for the given file input element.
   */
  CompletableFuture<Void> setFileInputFiles(SetFileInputFilesRequest request);

  /**
   * Sets if stack traces should be captured for Nodes. See `Node.getNodeStackTraces`. Default is disabled.
   */
  CompletableFuture<Void> setNodeStackTracesEnabled(SetNodeStackTracesEnabledRequest request);

  /**
   * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
   */
  CompletableFuture<GetNodeStackTracesResponse> getNodeStackTraces(
      GetNodeStackTracesRequest request);

  /**
   * Returns file information for the given
   * File wrapper.
   */
  CompletableFuture<GetFileInfoResponse> getFileInfo(GetFileInfoRequest request);

  /**
   * Returns list of detached nodes
   */
  CompletableFuture<GetDetachedDomNodesResponse> getDetachedDomNodes();

  /**
   * Enables console to refer to the node with given id via &dollar;x (see Command Line API for more details
   * &dollar;x functions).
   */
  CompletableFuture<Void> setInspectedNode(SetInspectedNodeRequest request);

  /**
   * Sets node name for a node with given id.
   */
  CompletableFuture<SetNodeNameResponse> setNodeName(SetNodeNameRequest request);

  /**
   * Sets node value for a node with given id.
   */
  CompletableFuture<Void> setNodeValue(SetNodeValueRequest request);

  /**
   * Sets node HTML markup, returns new node id.
   */
  CompletableFuture<Void> setOuterHTML(SetOuterHTMLRequest request);

  /**
   * Undoes the last performed action.
   */
  CompletableFuture<Void> undo();

  /**
   * Returns iframe node that owns iframe with the given domain.
   */
  CompletableFuture<GetFrameOwnerResponse> getFrameOwner(GetFrameOwnerRequest request);

  /**
   * Returns the query container of the given node based on container query
   * conditions: containerName, physical and logical axes, and whether it queries
   * scroll-state. If no axes are provided and queriesScrollState is false, the
   * style container is returned, which is the direct parent or the closest
   * element with a matching container-name.
   */
  CompletableFuture<GetContainerForNodeResponse> getContainerForNode(
      GetContainerForNodeRequest request);

  /**
   * Returns the descendants of a container query container that have
   * container queries against this container.
   */
  CompletableFuture<GetQueryingDescendantsForContainerResponse> getQueryingDescendantsForContainer(
      GetQueryingDescendantsForContainerRequest request);

  /**
   * Returns the target anchor element of the given anchor query according to
   * https://www.w3.org/TR/css-anchor-position-1/#target.
   */
  CompletableFuture<GetAnchorElementResponse> getAnchorElement(GetAnchorElementRequest request);

  Disposable onAttributeModified(Consumer<AttributeModifiedEvent> listener);

  Disposable onAttributeRemoved(Consumer<AttributeRemovedEvent> listener);

  Disposable onCharacterDataModified(Consumer<CharacterDataModifiedEvent> listener);

  Disposable onChildNodeCountUpdated(Consumer<ChildNodeCountUpdatedEvent> listener);

  Disposable onChildNodeInserted(Consumer<ChildNodeInsertedEvent> listener);

  Disposable onChildNodeRemoved(Consumer<ChildNodeRemovedEvent> listener);

  Disposable onDistributedNodesUpdated(Consumer<DistributedNodesUpdatedEvent> listener);

  Disposable onDocumentUpdated(Consumer<DocumentUpdatedEvent> listener);

  Disposable onInlineStyleInvalidated(Consumer<InlineStyleInvalidatedEvent> listener);

  Disposable onPseudoElementAdded(Consumer<PseudoElementAddedEvent> listener);

  Disposable onTopLayerElementsUpdated(Consumer<TopLayerElementsUpdatedEvent> listener);

  Disposable onScrollableFlagUpdated(Consumer<ScrollableFlagUpdatedEvent> listener);

  Disposable onPseudoElementRemoved(Consumer<PseudoElementRemovedEvent> listener);

  Disposable onSetChildNodes(Consumer<SetChildNodesEvent> listener);

  Disposable onShadowRootPopped(Consumer<ShadowRootPoppedEvent> listener);

  Disposable onShadowRootPushed(Consumer<ShadowRootPushedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class CollectClassNamesFromSubtreeRequest {
    /**
     * Id of the node to collect class names.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CollectClassNamesFromSubtreeResponse {
    /**
     * Class name list.
     */
    private final List<String> classNames;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CopyToRequest {
    /**
     * Id of the node to copy.
     */
    private final NodeId nodeId;

    /**
     * Id of the element to drop the copy into.
     */
    private final NodeId targetNodeId;

    /**
     * Drop the copy before this node (if absent, the copy becomes the last child of
     * `targetNodeId`).
     */
    @Nullable
    private final NodeId insertBeforeNodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CopyToResponse {
    /**
     * Id of the node clone.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DescribeNodeRequest {
    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;

    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
     * entire subtree or provide an integer larger than 0.
     */
    @Nullable
    private final Integer depth;

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
     * (default is false).
     */
    @Nullable
    private final Boolean pierce;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DescribeNodeResponse {
    /**
     * Node description.
     */
    private final Node node;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ScrollIntoViewIfNeededRequest {
    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;

    /**
     * The rect to be scrolled into view, relative to the node's border box, in CSS pixels.
     * When omitted, center of the node will be used, similar to Element.scrollIntoView.
     */
    @Nullable
    private final Rect rect;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DiscardSearchResultsRequest {
    /**
     * Unique search session identifier.
     */
    private final String searchId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    /**
     * Whether to include whitespaces in the children array of returned Nodes.
     */
    @Nullable
    @Experimental
    private final IncludeWhitespace includeWhitespace;

    public enum IncludeWhitespace {
      @JsonProperty("none")
      NONE,

      @JsonProperty("all")
      ALL
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class FocusRequest {
    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAttributesRequest {
    /**
     * Id of the node to retrieve attributes for.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAttributesResponse {
    /**
     * An interleaved array of node attribute names and values.
     */
    private final List<String> attributes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBoxModelRequest {
    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBoxModelResponse {
    /**
     * Box model for the node.
     */
    private final BoxModel model;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetContentQuadsRequest {
    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetContentQuadsResponse {
    /**
     * Quads that describe node layout relative to viewport.
     */
    private final List<Quad> quads;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDocumentRequest {
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
     * entire subtree or provide an integer larger than 0.
     */
    @Nullable
    private final Integer depth;

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
     * (default is false).
     */
    @Nullable
    private final Boolean pierce;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDocumentResponse {
    /**
     * Resulting node.
     */
    private final Node root;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFlattenedDocumentRequest {
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
     * entire subtree or provide an integer larger than 0.
     */
    @Nullable
    private final Integer depth;

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
     * (default is false).
     */
    @Nullable
    private final Boolean pierce;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFlattenedDocumentResponse {
    /**
     * Resulting node.
     */
    private final List<Node> nodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetNodesForSubtreeByStyleRequest {
    /**
     * Node ID pointing to the root of a subtree.
     */
    private final NodeId nodeId;

    /**
     * The style to filter nodes by (includes nodes if any of properties matches).
     */
    private final List<CSSComputedStyleProperty> computedStyles;

    /**
     * Whether or not iframes and shadow roots in the same target should be traversed when returning the
     * results (default is false).
     */
    @Nullable
    private final Boolean pierce;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetNodesForSubtreeByStyleResponse {
    /**
     * Resulting nodes.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetNodeForLocationRequest {
    /**
     * X coordinate.
     */
    private final Integer x;

    /**
     * Y coordinate.
     */
    private final Integer y;

    /**
     * False to skip to the nearest non-UA shadow root ancestor (default: false).
     */
    @Nullable
    private final Boolean includeUserAgentShadowDOM;

    /**
     * Whether to ignore pointer-events: none on elements and hit test them.
     */
    @Nullable
    private final Boolean ignorePointerEventsNone;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetNodeForLocationResponse {
    /**
     * Resulting node.
     */
    private final BackendNodeId backendNodeId;

    /**
     * Frame this node belongs to.
     */
    private final FrameId frameId;

    /**
     * Id of the node at given coordinates, only when enabled and requested document.
     */
    @Nullable
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetOuterHTMLRequest {
    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetOuterHTMLResponse {
    /**
     * Outer HTML markup.
     */
    private final String outerHTML;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRelayoutBoundaryRequest {
    /**
     * Id of the node.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRelayoutBoundaryResponse {
    /**
     * Relayout boundary node id for the given node.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSearchResultsRequest {
    /**
     * Unique search session identifier.
     */
    private final String searchId;

    /**
     * Start index of the search result to be returned.
     */
    private final Integer fromIndex;

    /**
     * End index of the search result to be returned.
     */
    private final Integer toIndex;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSearchResultsResponse {
    /**
     * Ids of the search result nodes.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class MoveToRequest {
    /**
     * Id of the node to move.
     */
    private final NodeId nodeId;

    /**
     * Id of the element to drop the moved node into.
     */
    private final NodeId targetNodeId;

    /**
     * Drop node before this one (if absent, the moved node becomes the last child of
     * `targetNodeId`).
     */
    @Nullable
    private final NodeId insertBeforeNodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class MoveToResponse {
    /**
     * New id of the moved node.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PerformSearchRequest {
    /**
     * Plain text or query selector or XPath search query.
     */
    private final String query;

    /**
     * True to search in user agent shadow DOM.
     */
    @Nullable
    private final Boolean includeUserAgentShadowDOM;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PerformSearchResponse {
    /**
     * Unique search session identifier.
     */
    private final String searchId;

    /**
     * Number of search results.
     */
    private final Integer resultCount;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PushNodeByPathToFrontendRequest {
    /**
     * Path to node in the proprietary format.
     */
    private final String path;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PushNodeByPathToFrontendResponse {
    /**
     * Id of the node for given path.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PushNodesByBackendIdsToFrontendRequest {
    /**
     * The array of backend node ids.
     */
    private final List<BackendNodeId> backendNodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PushNodesByBackendIdsToFrontendResponse {
    /**
     * The array of ids of pushed nodes that correspond to the backend ids specified in
     * backendNodeIds.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QuerySelectorRequest {
    /**
     * Id of the node to query upon.
     */
    private final NodeId nodeId;

    /**
     * Selector string.
     */
    private final String selector;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QuerySelectorResponse {
    /**
     * Query selector result.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QuerySelectorAllRequest {
    /**
     * Id of the node to query upon.
     */
    private final NodeId nodeId;

    /**
     * Selector string.
     */
    private final String selector;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QuerySelectorAllResponse {
    /**
     * Query selector result.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetTopLayerElementsResponse {
    /**
     * NodeIds of top layer elements
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetElementByRelationRequest {
    /**
     * Id of the node from which to query the relation.
     */
    private final NodeId nodeId;

    /**
     * Type of relation to get.
     */
    private final Relation relation;

    public enum Relation {
      @JsonProperty("PopoverTarget")
      POPOVER_TARGET,

      @JsonProperty("InterestTarget")
      INTEREST_TARGET
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetElementByRelationResponse {
    /**
     * NodeId of the element matching the queried relation.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveAttributeRequest {
    /**
     * Id of the element to remove attribute from.
     */
    private final NodeId nodeId;

    /**
     * Name of the attribute to remove.
     */
    private final String name;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveNodeRequest {
    /**
     * Id of the node to remove.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestChildNodesRequest {
    /**
     * Id of the node to get children for.
     */
    private final NodeId nodeId;

    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the
     * entire subtree or provide an integer larger than 0.
     */
    @Nullable
    private final Integer depth;

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the sub-tree
     * (default is false).
     */
    @Nullable
    private final Boolean pierce;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestNodeRequest {
    /**
     * JavaScript object id to convert into node.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestNodeResponse {
    /**
     * Node id for given object.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveNodeRequest {
    /**
     * Id of the node to resolve.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Backend identifier of the node to resolve.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    @Nullable
    private final String objectGroup;

    /**
     * Execution context in which to resolve the node.
     */
    @Nullable
    private final ExecutionContextId executionContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveNodeResponse {
    /**
     * JavaScript object wrapper for given node.
     */
    private final RemoteObject object;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAttributeValueRequest {
    /**
     * Id of the element to set attribute for.
     */
    private final NodeId nodeId;

    /**
     * Attribute name.
     */
    private final String name;

    /**
     * Attribute value.
     */
    private final String value;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAttributesAsTextRequest {
    /**
     * Id of the element to set attributes for.
     */
    private final NodeId nodeId;

    /**
     * Text with a number of attributes. Will parse this text using HTML parser.
     */
    private final String text;

    /**
     * Attribute name to replace with new attributes derived from text in case text parsed
     * successfully.
     */
    @Nullable
    private final String name;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetFileInputFilesRequest {
    /**
     * Array of file paths to set.
     */
    private final List<String> files;

    /**
     * Identifier of the node.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetNodeStackTracesEnabledRequest {
    /**
     * Enable or disable.
     */
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetNodeStackTracesRequest {
    /**
     * Id of the node to get stack traces for.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetNodeStackTracesResponse {
    /**
     * Creation stack trace, if available.
     */
    @Nullable
    private final StackTrace creation;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFileInfoRequest {
    /**
     * JavaScript object id of the node wrapper.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFileInfoResponse {
    private final String path;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDetachedDomNodesResponse {
    /**
     * The list of detached nodes
     */
    private final List<DetachedElementInfo> detachedNodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetInspectedNodeRequest {
    /**
     * DOM node id to be accessible by means of &dollar;x command line API.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetNodeNameRequest {
    /**
     * Id of the node to set name for.
     */
    private final NodeId nodeId;

    /**
     * New node's name.
     */
    private final String name;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetNodeNameResponse {
    /**
     * New node's id.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetNodeValueRequest {
    /**
     * Id of the node to set value for.
     */
    private final NodeId nodeId;

    /**
     * New node's value.
     */
    private final String value;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetOuterHTMLRequest {
    /**
     * Id of the node to set markup for.
     */
    private final NodeId nodeId;

    /**
     * Outer HTML markup to set.
     */
    private final String outerHTML;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFrameOwnerRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFrameOwnerResponse {
    /**
     * Resulting node.
     */
    private final BackendNodeId backendNodeId;

    /**
     * Id of the node at given coordinates, only when enabled and requested document.
     */
    @Nullable
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetContainerForNodeRequest {
    private final NodeId nodeId;

    @Nullable
    private final String containerName;

    @Nullable
    private final PhysicalAxes physicalAxes;

    @Nullable
    private final LogicalAxes logicalAxes;

    @Nullable
    private final Boolean queriesScrollState;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetContainerForNodeResponse {
    /**
     * The container node for the given node, or null if not found.
     */
    @Nullable
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetQueryingDescendantsForContainerRequest {
    /**
     * Id of the container node to find querying descendants from.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetQueryingDescendantsForContainerResponse {
    /**
     * Descendant nodes with container queries against the given container.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAnchorElementRequest {
    /**
     * Id of the positioned element from which to find the anchor.
     */
    private final NodeId nodeId;

    /**
     * An optional anchor specifier, as defined in
     * https://www.w3.org/TR/css-anchor-position-1/#anchor-specifier.
     * If not provided, it will return the implicit anchor element for
     * the given positioned element.
     */
    @Nullable
    private final String anchorSpecifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAnchorElementResponse {
    /**
     * The anchor element of the given anchor query.
     */
    private final NodeId nodeId;
  }

  /**
   * Fired when `Element`'s attribute is modified.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("attributeModified")
  class AttributeModifiedEvent {
    /**
     * Id of the node that has changed.
     */
    private final NodeId nodeId;

    /**
     * Attribute name.
     */
    private final String name;

    /**
     * Attribute value.
     */
    private final String value;
  }

  /**
   * Fired when `Element`'s attribute is removed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("attributeRemoved")
  class AttributeRemovedEvent {
    /**
     * Id of the node that has changed.
     */
    private final NodeId nodeId;

    /**
     * A ttribute name.
     */
    private final String name;
  }

  /**
   * Mirrors `DOMCharacterDataModified` event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("characterDataModified")
  class CharacterDataModifiedEvent {
    /**
     * Id of the node that has changed.
     */
    private final NodeId nodeId;

    /**
     * New text value.
     */
    private final String characterData;
  }

  /**
   * Fired when `Container`'s child node count has changed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("childNodeCountUpdated")
  class ChildNodeCountUpdatedEvent {
    /**
     * Id of the node that has changed.
     */
    private final NodeId nodeId;

    /**
     * New node count.
     */
    private final Integer childNodeCount;
  }

  /**
   * Mirrors `DOMNodeInserted` event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("childNodeInserted")
  class ChildNodeInsertedEvent {
    /**
     * Id of the node that has changed.
     */
    private final NodeId parentNodeId;

    /**
     * Id of the previous sibling.
     */
    private final NodeId previousNodeId;

    /**
     * Inserted node data.
     */
    private final Node node;
  }

  /**
   * Mirrors `DOMNodeRemoved` event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("childNodeRemoved")
  class ChildNodeRemovedEvent {
    /**
     * Parent id.
     */
    private final NodeId parentNodeId;

    /**
     * Id of the node that has been removed.
     */
    private final NodeId nodeId;
  }

  /**
   * Called when distribution is changed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("distributedNodesUpdated")
  class DistributedNodesUpdatedEvent {
    /**
     * Insertion point where distributed nodes were updated.
     */
    private final NodeId insertionPointId;

    /**
     * Distributed nodes for given insertion point.
     */
    private final List<BackendNode> distributedNodes;
  }

  /**
   * Fired when `Document` has been totally updated. Node ids are no longer valid.
   */
  @JsonTypeName("documentUpdated")
  class DocumentUpdatedEvent {
  }

  /**
   * Fired when `Element`'s inline style is modified via a CSS property modification.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("inlineStyleInvalidated")
  class InlineStyleInvalidatedEvent {
    /**
     * Ids of the nodes for which the inline styles have been invalidated.
     */
    private final List<NodeId> nodeIds;
  }

  /**
   * Called when a pseudo element is added to an element.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("pseudoElementAdded")
  class PseudoElementAddedEvent {
    /**
     * Pseudo element's parent element id.
     */
    private final NodeId parentId;

    /**
     * The added pseudo element.
     */
    private final Node pseudoElement;
  }

  /**
   * Called when top layer elements are changed.
   */
  @JsonTypeName("topLayerElementsUpdated")
  class TopLayerElementsUpdatedEvent {
  }

  /**
   * Fired when a node's scrollability state changes.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("scrollableFlagUpdated")
  class ScrollableFlagUpdatedEvent {
    /**
     * The id of the node.
     */
    private final NodeId nodeId;

    /**
     * If the node is scrollable.
     */
    private final Boolean isScrollable;
  }

  /**
   * Called when a pseudo element is removed from an element.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("pseudoElementRemoved")
  class PseudoElementRemovedEvent {
    /**
     * Pseudo element's parent element id.
     */
    private final NodeId parentId;

    /**
     * The removed pseudo element id.
     */
    private final NodeId pseudoElementId;
  }

  /**
   * Fired when backend wants to provide client with the missing DOM structure. This happens upon
   * most of the calls requesting node ids.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("setChildNodes")
  class SetChildNodesEvent {
    /**
     * Parent node id to populate with children.
     */
    private final NodeId parentId;

    /**
     * Child nodes array.
     */
    private final List<Node> nodes;
  }

  /**
   * Called when shadow root is popped from the element.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("shadowRootPopped")
  class ShadowRootPoppedEvent {
    /**
     * Host element id.
     */
    private final NodeId hostId;

    /**
     * Shadow root id.
     */
    private final NodeId rootId;
  }

  /**
   * Called when shadow root is pushed into the element.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("shadowRootPushed")
  class ShadowRootPushedEvent {
    /**
     * Host element id.
     */
    private final NodeId hostId;

    /**
     * Shadow root.
     */
    private final Node root;
  }
}
