package org.deripas.chrome.protocol.api.accessibility;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
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
import org.deripas.chrome.protocol.api.Disposable;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.dom.NodeId;
import org.deripas.chrome.protocol.api.page.FrameId;
import org.deripas.chrome.protocol.api.runtime.RemoteObjectId;

@Experimental
@Generated
public interface Accessibility {
  /**
   * Disables the accessibility domain.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables the accessibility domain which causes `AXNodeId`s to remain consistent between method calls.
   * This turns on accessibility for the page, which can impact performance until accessibility is disabled.
   */
  CompletableFuture<Void> enable();

  /**
   * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
   */
  CompletableFuture<GetPartialAXTreeResponse> getPartialAXTree(GetPartialAXTreeRequest request);

  /**
   * Fetches the entire accessibility tree for the root Document
   */
  CompletableFuture<GetFullAXTreeResponse> getFullAXTree(GetFullAXTreeRequest request);

  /**
   * Fetches the root node.
   * Requires `enable()` to have been called previously.
   */
  CompletableFuture<GetRootAXNodeResponse> getRootAXNode(GetRootAXNodeRequest request);

  /**
   * Fetches a node and all ancestors up to and including the root.
   * Requires `enable()` to have been called previously.
   */
  CompletableFuture<GetAXNodeAndAncestorsResponse> getAXNodeAndAncestors(
      GetAXNodeAndAncestorsRequest request);

  /**
   * Fetches a particular accessibility node by AXNodeId.
   * Requires `enable()` to have been called previously.
   */
  CompletableFuture<GetChildAXNodesResponse> getChildAXNodes(GetChildAXNodesRequest request);

  /**
   * Query a DOM node's accessibility subtree for accessible name and role.
   * This command computes the name and role for all nodes in the subtree, including those that are
   * ignored for accessibility, and returns those that match the specified name and role. If no DOM
   * node is specified, or the DOM node does not exist, the command returns an error. If neither
   * `accessibleName` or `role` is specified, it returns all the accessibility nodes in the subtree.
   */
  CompletableFuture<QueryAXTreeResponse> queryAXTree(QueryAXTreeRequest request);

  Disposable onLoadComplete(Consumer<LoadCompleteEvent> listener);

  Disposable onNodesUpdated(Consumer<NodesUpdatedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPartialAXTreeRequest {
    /**
     * Identifier of the node to get the partial accessibility tree for.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node to get the partial accessibility tree for.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper to get the partial accessibility tree for.
     */
    @Nullable
    private final RemoteObjectId objectId;

    /**
     * Whether to fetch this node's ancestors, siblings and children. Defaults to true.
     */
    @Nullable
    private final Boolean fetchRelatives;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPartialAXTreeResponse {
    /**
     * The `Accessibility.AXNode` for this DOM node, if it exists, plus its ancestors, siblings and
     * children, if requested.
     */
    private final List<AXNode> nodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFullAXTreeRequest {
    /**
     * The maximum depth at which descendants of the root node should be retrieved.
     * If omitted, the full tree is returned.
     */
    @Nullable
    private final Integer depth;

    /**
     * The frame for whose document the AX tree should be retrieved.
     * If omitted, the root frame is used.
     */
    @Nullable
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetFullAXTreeResponse {
    private final List<AXNode> nodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRootAXNodeRequest {
    /**
     * The frame in whose document the node resides.
     * If omitted, the root frame is used.
     */
    @Nullable
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRootAXNodeResponse {
    private final AXNode node;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAXNodeAndAncestorsRequest {
    /**
     * Identifier of the node to get.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node to get.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper to get.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAXNodeAndAncestorsResponse {
    private final List<AXNode> nodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetChildAXNodesRequest {
    private final AXNodeId id;

    /**
     * The frame in whose document the node resides.
     * If omitted, the root frame is used.
     */
    @Nullable
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetChildAXNodesResponse {
    private final List<AXNode> nodes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QueryAXTreeRequest {
    /**
     * Identifier of the node for the root to query.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node for the root to query.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node wrapper for the root to query.
     */
    @Nullable
    private final RemoteObjectId objectId;

    /**
     * Find nodes with this computed name.
     */
    @Nullable
    private final String accessibleName;

    /**
     * Find nodes with this computed role.
     */
    @Nullable
    private final String role;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class QueryAXTreeResponse {
    /**
     * A list of `Accessibility.AXNode` matching the specified attributes,
     * including nodes that are ignored for accessibility.
     */
    private final List<AXNode> nodes;
  }

  /**
   * The loadComplete event mirrors the load complete event sent by the browser to assistive
   * technology when the web page has finished loading.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("loadComplete")
  class LoadCompleteEvent {
    /**
     * New document root node.
     */
    private final AXNode root;
  }

  /**
   * The nodesUpdated event is sent every time a previously requested node has changed the in tree.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("nodesUpdated")
  class NodesUpdatedEvent {
    /**
     * Updated node data.
     */
    private final List<AXNode> nodes;
  }
}
