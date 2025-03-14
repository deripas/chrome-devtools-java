package io.github.deripas.chrome.devtools.api.dom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object
 * that has an `id`. This `id` can be used to get additional information on the Node, resolve it into
 * the JavaScript object wrapper, etc. It is important that client receives DOM events only for the
 * nodes that are known to the client. Backend keeps track of the nodes that were sent to the client
 * and never sends the same node twice. It is client's responsibility to collect information about
 * the nodes that were sent to the client. Note that `iframe` owner elements will return
 * corresponding document elements as their child nodes.
 */
@RequiredArgsConstructor
@Generated
public class DOM {
  private final Session session;

  /**
   * Collects class names for the node with given id and all of it's child nodes.
   */
  public CompletableFuture<CollectClassNamesFromSubtreeResponse> collectClassNamesFromSubtree(
      CollectClassNamesFromSubtreeRequest request) {
    return session.send("DOM.collectClassNamesFromSubtree", request, CollectClassNamesFromSubtreeResponse.class);
  }

  /**
   * Creates a deep copy of the specified node and places it into the target container before the
   * given anchor.
   */
  public CompletableFuture<CopyToResponse> copyTo(CopyToRequest request) {
    return session.send("DOM.copyTo", request, CopyToResponse.class);
  }

  /**
   * Describes node given its id, does not require domain to be enabled. Does not start tracking any
   * objects, can be used for automation.
   */
  public CompletableFuture<DescribeNodeResponse> describeNode(DescribeNodeRequest request) {
    return session.send("DOM.describeNode", request, DescribeNodeResponse.class);
  }

  /**
   * Scrolls the specified rect of the given node into view if not already visible.
   * Note: exactly one between nodeId, backendNodeId and objectId should be passed
   * to identify the node.
   */
  public CompletableFuture<Void> scrollIntoViewIfNeeded(ScrollIntoViewIfNeededRequest request) {
    return session.send("DOM.scrollIntoViewIfNeeded", request, Void.class);
  }

  /**
   * Disables DOM agent for the given page.
   */
  public CompletableFuture<Void> disable() {
    return session.send("DOM.disable", null, Void.class);
  }

  /**
   * Discards search results from the session with the given id. `getSearchResults` should no longer
   * be called for that search.
   */
  public CompletableFuture<Void> discardSearchResults(DiscardSearchResultsRequest request) {
    return session.send("DOM.discardSearchResults", request, Void.class);
  }

  /**
   * Enables DOM agent for the given page.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("DOM.enable", request, Void.class);
  }

  /**
   * Focuses the given element.
   */
  public CompletableFuture<Void> focus(FocusRequest request) {
    return session.send("DOM.focus", request, Void.class);
  }

  /**
   * Returns attributes for the specified node.
   */
  public CompletableFuture<GetAttributesResponse> getAttributes(GetAttributesRequest request) {
    return session.send("DOM.getAttributes", request, GetAttributesResponse.class);
  }

  /**
   * Returns boxes for the given node.
   */
  public CompletableFuture<GetBoxModelResponse> getBoxModel(GetBoxModelRequest request) {
    return session.send("DOM.getBoxModel", request, GetBoxModelResponse.class);
  }

  /**
   * Returns quads that describe node position on the page. This method
   * might return multiple quads for inline nodes.
   */
  public CompletableFuture<GetContentQuadsResponse> getContentQuads(
      GetContentQuadsRequest request) {
    return session.send("DOM.getContentQuads", request, GetContentQuadsResponse.class);
  }

  /**
   * Returns the root DOM node (and optionally the subtree) to the caller.
   * Implicitly enables the DOM domain events for the current target.
   */
  public CompletableFuture<GetDocumentResponse> getDocument(GetDocumentRequest request) {
    return session.send("DOM.getDocument", request, GetDocumentResponse.class);
  }

  /**
   * Returns the root DOM node (and optionally the subtree) to the caller.
   * Deprecated, as it is not designed to work well with the rest of the DOM agent.
   * Use DOMSnapshot.captureSnapshot instead.
   */
  @Deprecated
  public CompletableFuture<GetFlattenedDocumentResponse> getFlattenedDocument(
      GetFlattenedDocumentRequest request) {
    return session.send("DOM.getFlattenedDocument", request, GetFlattenedDocumentResponse.class);
  }

  /**
   * Finds nodes with a given computed style in a subtree.
   */
  public CompletableFuture<GetNodesForSubtreeByStyleResponse> getNodesForSubtreeByStyle(
      GetNodesForSubtreeByStyleRequest request) {
    return session.send("DOM.getNodesForSubtreeByStyle", request, GetNodesForSubtreeByStyleResponse.class);
  }

  /**
   * Returns node id at given location. Depending on whether DOM domain is enabled, nodeId is
   * either returned or not.
   */
  public CompletableFuture<GetNodeForLocationResponse> getNodeForLocation(
      GetNodeForLocationRequest request) {
    return session.send("DOM.getNodeForLocation", request, GetNodeForLocationResponse.class);
  }

  /**
   * Returns node's HTML markup.
   */
  public CompletableFuture<GetOuterHTMLResponse> getOuterHTML(GetOuterHTMLRequest request) {
    return session.send("DOM.getOuterHTML", request, GetOuterHTMLResponse.class);
  }

  /**
   * Returns the id of the nearest ancestor that is a relayout boundary.
   */
  public CompletableFuture<GetRelayoutBoundaryResponse> getRelayoutBoundary(
      GetRelayoutBoundaryRequest request) {
    return session.send("DOM.getRelayoutBoundary", request, GetRelayoutBoundaryResponse.class);
  }

  /**
   * Returns search results from given `fromIndex` to given `toIndex` from the search with the given
   * identifier.
   */
  public CompletableFuture<GetSearchResultsResponse> getSearchResults(
      GetSearchResultsRequest request) {
    return session.send("DOM.getSearchResults", request, GetSearchResultsResponse.class);
  }

  /**
   * Hides any highlight.
   */
  public CompletableFuture<Void> hideHighlight() {
    return session.send("DOM.hideHighlight", null, Void.class);
  }

  /**
   * Highlights DOM node.
   */
  public CompletableFuture<Void> highlightNode() {
    return session.send("DOM.highlightNode", null, Void.class);
  }

  /**
   * Highlights given rectangle.
   */
  public CompletableFuture<Void> highlightRect() {
    return session.send("DOM.highlightRect", null, Void.class);
  }

  /**
   * Marks last undoable state.
   */
  public CompletableFuture<Void> markUndoableState() {
    return session.send("DOM.markUndoableState", null, Void.class);
  }

  /**
   * Moves node into the new container, places it before the given anchor.
   */
  public CompletableFuture<MoveToResponse> moveTo(MoveToRequest request) {
    return session.send("DOM.moveTo", request, MoveToResponse.class);
  }

  /**
   * Searches for a given string in the DOM tree. Use `getSearchResults` to access search results or
   * `cancelSearch` to end this search session.
   */
  public CompletableFuture<PerformSearchResponse> performSearch(PerformSearchRequest request) {
    return session.send("DOM.performSearch", request, PerformSearchResponse.class);
  }

  /**
   * Requests that the node is sent to the caller given its path. // FIXME, use XPath
   */
  public CompletableFuture<PushNodeByPathToFrontendResponse> pushNodeByPathToFrontend(
      PushNodeByPathToFrontendRequest request) {
    return session.send("DOM.pushNodeByPathToFrontend", request, PushNodeByPathToFrontendResponse.class);
  }

  /**
   * Requests that a batch of nodes is sent to the caller given their backend node ids.
   */
  public CompletableFuture<PushNodesByBackendIdsToFrontendResponse> pushNodesByBackendIdsToFrontend(
      PushNodesByBackendIdsToFrontendRequest request) {
    return session.send("DOM.pushNodesByBackendIdsToFrontend", request, PushNodesByBackendIdsToFrontendResponse.class);
  }

  /**
   * Executes `querySelector` on a given node.
   */
  public CompletableFuture<QuerySelectorResponse> querySelector(QuerySelectorRequest request) {
    return session.send("DOM.querySelector", request, QuerySelectorResponse.class);
  }

  /**
   * Executes `querySelectorAll` on a given node.
   */
  public CompletableFuture<QuerySelectorAllResponse> querySelectorAll(
      QuerySelectorAllRequest request) {
    return session.send("DOM.querySelectorAll", request, QuerySelectorAllResponse.class);
  }

  /**
   * Returns NodeIds of current top layer elements.
   * Top layer is rendered closest to the user within a viewport, therefore its elements always
   * appear on top of all other content.
   */
  public CompletableFuture<GetTopLayerElementsResponse> getTopLayerElements() {
    return session.send("DOM.getTopLayerElements", null, GetTopLayerElementsResponse.class);
  }

  /**
   * Returns the NodeId of the matched element according to certain relations.
   */
  public CompletableFuture<GetElementByRelationResponse> getElementByRelation(
      GetElementByRelationRequest request) {
    return session.send("DOM.getElementByRelation", request, GetElementByRelationResponse.class);
  }

  /**
   * Re-does the last undone action.
   */
  public CompletableFuture<Void> redo() {
    return session.send("DOM.redo", null, Void.class);
  }

  /**
   * Removes attribute with given name from an element with given id.
   */
  public CompletableFuture<Void> removeAttribute(RemoveAttributeRequest request) {
    return session.send("DOM.removeAttribute", request, Void.class);
  }

  /**
   * Removes node with given id.
   */
  public CompletableFuture<Void> removeNode(RemoveNodeRequest request) {
    return session.send("DOM.removeNode", request, Void.class);
  }

  /**
   * Requests that children of the node with given id are returned to the caller in form of
   * `setChildNodes` events where not only immediate children are retrieved, but all children down to
   * the specified depth.
   */
  public CompletableFuture<Void> requestChildNodes(RequestChildNodesRequest request) {
    return session.send("DOM.requestChildNodes", request, Void.class);
  }

  /**
   * Requests that the node is sent to the caller given the JavaScript node object reference. All
   * nodes that form the path from the node to the root are also sent to the client as a series of
   * `setChildNodes` notifications.
   */
  public CompletableFuture<RequestNodeResponse> requestNode(RequestNodeRequest request) {
    return session.send("DOM.requestNode", request, RequestNodeResponse.class);
  }

  /**
   * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
   */
  public CompletableFuture<ResolveNodeResponse> resolveNode(ResolveNodeRequest request) {
    return session.send("DOM.resolveNode", request, ResolveNodeResponse.class);
  }

  /**
   * Sets attribute for an element with given id.
   */
  public CompletableFuture<Void> setAttributeValue(SetAttributeValueRequest request) {
    return session.send("DOM.setAttributeValue", request, Void.class);
  }

  /**
   * Sets attributes on element with given id. This method is useful when user edits some existing
   * attribute value and types in several attribute name/value pairs.
   */
  public CompletableFuture<Void> setAttributesAsText(SetAttributesAsTextRequest request) {
    return session.send("DOM.setAttributesAsText", request, Void.class);
  }

  /**
   * Sets files for the given file input element.
   */
  public CompletableFuture<Void> setFileInputFiles(SetFileInputFilesRequest request) {
    return session.send("DOM.setFileInputFiles", request, Void.class);
  }

  /**
   * Sets if stack traces should be captured for Nodes. See `Node.getNodeStackTraces`. Default is disabled.
   */
  public CompletableFuture<Void> setNodeStackTracesEnabled(
      SetNodeStackTracesEnabledRequest request) {
    return session.send("DOM.setNodeStackTracesEnabled", request, Void.class);
  }

  /**
   * Gets stack traces associated with a Node. As of now, only provides stack trace for Node creation.
   */
  public CompletableFuture<GetNodeStackTracesResponse> getNodeStackTraces(
      GetNodeStackTracesRequest request) {
    return session.send("DOM.getNodeStackTraces", request, GetNodeStackTracesResponse.class);
  }

  /**
   * Returns file information for the given
   * File wrapper.
   */
  public CompletableFuture<GetFileInfoResponse> getFileInfo(GetFileInfoRequest request) {
    return session.send("DOM.getFileInfo", request, GetFileInfoResponse.class);
  }

  /**
   * Returns list of detached nodes
   */
  public CompletableFuture<GetDetachedDomNodesResponse> getDetachedDomNodes() {
    return session.send("DOM.getDetachedDomNodes", null, GetDetachedDomNodesResponse.class);
  }

  /**
   * Enables console to refer to the node with given id via &dollar;x (see Command Line API for more details
   * &dollar;x functions).
   */
  public CompletableFuture<Void> setInspectedNode(SetInspectedNodeRequest request) {
    return session.send("DOM.setInspectedNode", request, Void.class);
  }

  /**
   * Sets node name for a node with given id.
   */
  public CompletableFuture<SetNodeNameResponse> setNodeName(SetNodeNameRequest request) {
    return session.send("DOM.setNodeName", request, SetNodeNameResponse.class);
  }

  /**
   * Sets node value for a node with given id.
   */
  public CompletableFuture<Void> setNodeValue(SetNodeValueRequest request) {
    return session.send("DOM.setNodeValue", request, Void.class);
  }

  /**
   * Sets node HTML markup, returns new node id.
   */
  public CompletableFuture<Void> setOuterHTML(SetOuterHTMLRequest request) {
    return session.send("DOM.setOuterHTML", request, Void.class);
  }

  /**
   * Undoes the last performed action.
   */
  public CompletableFuture<Void> undo() {
    return session.send("DOM.undo", null, Void.class);
  }

  /**
   * Returns iframe node that owns iframe with the given domain.
   */
  public CompletableFuture<GetFrameOwnerResponse> getFrameOwner(GetFrameOwnerRequest request) {
    return session.send("DOM.getFrameOwner", request, GetFrameOwnerResponse.class);
  }

  /**
   * Returns the query container of the given node based on container query
   * conditions: containerName, physical and logical axes, and whether it queries
   * scroll-state. If no axes are provided and queriesScrollState is false, the
   * style container is returned, which is the direct parent or the closest
   * element with a matching container-name.
   */
  public CompletableFuture<GetContainerForNodeResponse> getContainerForNode(
      GetContainerForNodeRequest request) {
    return session.send("DOM.getContainerForNode", request, GetContainerForNodeResponse.class);
  }

  /**
   * Returns the descendants of a container query container that have
   * container queries against this container.
   */
  public CompletableFuture<GetQueryingDescendantsForContainerResponse> getQueryingDescendantsForContainer(
      GetQueryingDescendantsForContainerRequest request) {
    return session.send("DOM.getQueryingDescendantsForContainer", request, GetQueryingDescendantsForContainerResponse.class);
  }

  /**
   * Returns the target anchor element of the given anchor query according to
   * https://www.w3.org/TR/css-anchor-position-1/#target.
   */
  public CompletableFuture<GetAnchorElementResponse> getAnchorElement(
      GetAnchorElementRequest request) {
    return session.send("DOM.getAnchorElement", request, GetAnchorElementResponse.class);
  }

  public Disposable onAttributeModified(Consumer<AttributeModifiedEvent> listener) {
    return session.subscribe("DOM.attributeModified", listener, AttributeModifiedEvent.class);
  }

  public Disposable onAttributeRemoved(Consumer<AttributeRemovedEvent> listener) {
    return session.subscribe("DOM.attributeRemoved", listener, AttributeRemovedEvent.class);
  }

  public Disposable onCharacterDataModified(Consumer<CharacterDataModifiedEvent> listener) {
    return session.subscribe("DOM.characterDataModified", listener, CharacterDataModifiedEvent.class);
  }

  public Disposable onChildNodeCountUpdated(Consumer<ChildNodeCountUpdatedEvent> listener) {
    return session.subscribe("DOM.childNodeCountUpdated", listener, ChildNodeCountUpdatedEvent.class);
  }

  public Disposable onChildNodeInserted(Consumer<ChildNodeInsertedEvent> listener) {
    return session.subscribe("DOM.childNodeInserted", listener, ChildNodeInsertedEvent.class);
  }

  public Disposable onChildNodeRemoved(Consumer<ChildNodeRemovedEvent> listener) {
    return session.subscribe("DOM.childNodeRemoved", listener, ChildNodeRemovedEvent.class);
  }

  public Disposable onDistributedNodesUpdated(Consumer<DistributedNodesUpdatedEvent> listener) {
    return session.subscribe("DOM.distributedNodesUpdated", listener, DistributedNodesUpdatedEvent.class);
  }

  public Disposable onDocumentUpdated(Consumer<DocumentUpdatedEvent> listener) {
    return session.subscribe("DOM.documentUpdated", listener, DocumentUpdatedEvent.class);
  }

  public Disposable onInlineStyleInvalidated(Consumer<InlineStyleInvalidatedEvent> listener) {
    return session.subscribe("DOM.inlineStyleInvalidated", listener, InlineStyleInvalidatedEvent.class);
  }

  public Disposable onPseudoElementAdded(Consumer<PseudoElementAddedEvent> listener) {
    return session.subscribe("DOM.pseudoElementAdded", listener, PseudoElementAddedEvent.class);
  }

  public Disposable onTopLayerElementsUpdated(Consumer<TopLayerElementsUpdatedEvent> listener) {
    return session.subscribe("DOM.topLayerElementsUpdated", listener, TopLayerElementsUpdatedEvent.class);
  }

  public Disposable onScrollableFlagUpdated(Consumer<ScrollableFlagUpdatedEvent> listener) {
    return session.subscribe("DOM.scrollableFlagUpdated", listener, ScrollableFlagUpdatedEvent.class);
  }

  public Disposable onPseudoElementRemoved(Consumer<PseudoElementRemovedEvent> listener) {
    return session.subscribe("DOM.pseudoElementRemoved", listener, PseudoElementRemovedEvent.class);
  }

  public Disposable onSetChildNodes(Consumer<SetChildNodesEvent> listener) {
    return session.subscribe("DOM.setChildNodes", listener, SetChildNodesEvent.class);
  }

  public Disposable onShadowRootPopped(Consumer<ShadowRootPoppedEvent> listener) {
    return session.subscribe("DOM.shadowRootPopped", listener, ShadowRootPoppedEvent.class);
  }

  public Disposable onShadowRootPushed(Consumer<ShadowRootPushedEvent> listener) {
    return session.subscribe("DOM.shadowRootPushed", listener, ShadowRootPushedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CollectClassNamesFromSubtreeRequest {
    /**
     * Id of the node to collect class names.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CollectClassNamesFromSubtreeResponse {
    /**
     * Class name list.
     */
    private final List<String> classNames;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CopyToRequest {
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
  public static class CopyToResponse {
    /**
     * Id of the node clone.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DescribeNodeRequest {
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
  public static class DescribeNodeResponse {
    /**
     * Node description.
     */
    private final Node node;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScrollIntoViewIfNeededRequest {
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
  public static class DiscardSearchResultsRequest {
    /**
     * Unique search session identifier.
     */
    private final String searchId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
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
  public static class FocusRequest {
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
  public static class GetAttributesRequest {
    /**
     * Id of the node to retrieve attributes for.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAttributesResponse {
    /**
     * An interleaved array of node attribute names and values.
     */
    private final List<String> attributes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetBoxModelRequest {
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
  public static class GetBoxModelResponse {
    /**
     * Box model for the node.
     */
    private final BoxModel model;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetContentQuadsRequest {
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
  public static class GetContentQuadsResponse {
    /**
     * Quads that describe node layout relative to viewport.
     */
    private final List<Quad> quads;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDocumentRequest {
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
  public static class GetDocumentResponse {
    /**
     * Resulting node.
     */
    private final Node root;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetFlattenedDocumentRequest {
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
  public static class GetFlattenedDocumentResponse {
    /**
     * Resulting node.
     */
    private final List<Node> nodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetNodesForSubtreeByStyleRequest {
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
  public static class GetNodesForSubtreeByStyleResponse {
    /**
     * Resulting nodes.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetNodeForLocationRequest {
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
  public static class GetNodeForLocationResponse {
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
  public static class GetOuterHTMLRequest {
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
  public static class GetOuterHTMLResponse {
    /**
     * Outer HTML markup.
     */
    private final String outerHTML;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetRelayoutBoundaryRequest {
    /**
     * Id of the node.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetRelayoutBoundaryResponse {
    /**
     * Relayout boundary node id for the given node.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSearchResultsRequest {
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
  public static class GetSearchResultsResponse {
    /**
     * Ids of the search result nodes.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class MoveToRequest {
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
  public static class MoveToResponse {
    /**
     * New id of the moved node.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PerformSearchRequest {
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
  public static class PerformSearchResponse {
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
  public static class PushNodeByPathToFrontendRequest {
    /**
     * Path to node in the proprietary format.
     */
    private final String path;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PushNodeByPathToFrontendResponse {
    /**
     * Id of the node for given path.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PushNodesByBackendIdsToFrontendRequest {
    /**
     * The array of backend node ids.
     */
    private final List<BackendNodeId> backendNodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PushNodesByBackendIdsToFrontendResponse {
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
  public static class QuerySelectorRequest {
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
  public static class QuerySelectorResponse {
    /**
     * Query selector result.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class QuerySelectorAllRequest {
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
  public static class QuerySelectorAllResponse {
    /**
     * Query selector result.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetTopLayerElementsResponse {
    /**
     * NodeIds of top layer elements
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetElementByRelationRequest {
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
  public static class GetElementByRelationResponse {
    /**
     * NodeId of the element matching the queried relation.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveAttributeRequest {
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
  public static class RemoveNodeRequest {
    /**
     * Id of the node to remove.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestChildNodesRequest {
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
  public static class RequestNodeRequest {
    /**
     * JavaScript object id to convert into node.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RequestNodeResponse {
    /**
     * Node id for given object.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResolveNodeRequest {
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
  public static class ResolveNodeResponse {
    /**
     * JavaScript object wrapper for given node.
     */
    private final RemoteObject object;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAttributeValueRequest {
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
  public static class SetAttributesAsTextRequest {
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
  public static class SetFileInputFilesRequest {
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
  public static class SetNodeStackTracesEnabledRequest {
    /**
     * Enable or disable.
     */
    private final Boolean enable;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetNodeStackTracesRequest {
    /**
     * Id of the node to get stack traces for.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetNodeStackTracesResponse {
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
  public static class GetFileInfoRequest {
    /**
     * JavaScript object id of the node wrapper.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetFileInfoResponse {
    private final String path;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDetachedDomNodesResponse {
    /**
     * The list of detached nodes
     */
    private final List<DetachedElementInfo> detachedNodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInspectedNodeRequest {
    /**
     * DOM node id to be accessible by means of &dollar;x command line API.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetNodeNameRequest {
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
  public static class SetNodeNameResponse {
    /**
     * New node's id.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetNodeValueRequest {
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
  public static class SetOuterHTMLRequest {
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
  public static class GetFrameOwnerRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetFrameOwnerResponse {
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
  public static class GetContainerForNodeRequest {
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
  public static class GetContainerForNodeResponse {
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
  public static class GetQueryingDescendantsForContainerRequest {
    /**
     * Id of the container node to find querying descendants from.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetQueryingDescendantsForContainerResponse {
    /**
     * Descendant nodes with container queries against the given container.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAnchorElementRequest {
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
  public static class GetAnchorElementResponse {
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
  public static class AttributeModifiedEvent {
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
  public static class AttributeRemovedEvent {
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
  public static class CharacterDataModifiedEvent {
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
  public static class ChildNodeCountUpdatedEvent {
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
  public static class ChildNodeInsertedEvent {
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
  public static class ChildNodeRemovedEvent {
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
  public static class DistributedNodesUpdatedEvent {
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
  public static class DocumentUpdatedEvent {
  }

  /**
   * Fired when `Element`'s inline style is modified via a CSS property modification.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class InlineStyleInvalidatedEvent {
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
  public static class PseudoElementAddedEvent {
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
  public static class TopLayerElementsUpdatedEvent {
  }

  /**
   * Fired when a node's scrollability state changes.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScrollableFlagUpdatedEvent {
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
  public static class PseudoElementRemovedEvent {
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
  public static class SetChildNodesEvent {
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
  public static class ShadowRootPoppedEvent {
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
  public static class ShadowRootPushedEvent {
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
