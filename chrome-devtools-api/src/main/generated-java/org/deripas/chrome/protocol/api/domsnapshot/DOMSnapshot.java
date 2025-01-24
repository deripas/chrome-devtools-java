package org.deripas.chrome.protocol.api.domsnapshot;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain facilitates obtaining document snapshots with DOM, layout, and style information.
 */
@Experimental
@Generated
public interface DOMSnapshot {
  /**
   * Disables DOM snapshot agent for the given page.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables DOM snapshot agent for the given page.
   */
  CompletableFuture<Void> enable();

  /**
   * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
   * template contents, and imported documents) in a flattened array, as well as layout and
   * white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
   * flattened.
   */
  @Deprecated
  CompletableFuture<GetSnapshotResponse> getSnapshot(GetSnapshotRequest request);

  /**
   * Returns a document snapshot, including the full DOM tree of the root node (including iframes,
   * template contents, and imported documents) in a flattened array, as well as layout and
   * white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is
   * flattened.
   */
  CompletableFuture<CaptureSnapshotResponse> captureSnapshot(CaptureSnapshotRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSnapshotRequest {
    /**
     * Whitelist of computed styles to return.
     */
    private final List<String> computedStyleWhitelist;

    /**
     * Whether or not to retrieve details of DOM listeners (default false).
     */
    @Nullable
    private final Boolean includeEventListeners;

    /**
     * Whether to determine and include the paint order index of LayoutTreeNodes (default false).
     */
    @Nullable
    private final Boolean includePaintOrder;

    /**
     * Whether to include UA shadow tree in the snapshot (default false).
     */
    @Nullable
    private final Boolean includeUserAgentShadowTree;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSnapshotResponse {
    /**
     * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
     */
    private final List<DOMNode> domNodes;

    /**
     * The nodes in the layout tree.
     */
    private final List<LayoutTreeNode> layoutTreeNodes;

    /**
     * Whitelisted ComputedStyle properties for each node in the layout tree.
     */
    private final List<ComputedStyle> computedStyles;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CaptureSnapshotRequest {
    /**
     * Whitelist of computed styles to return.
     */
    private final List<String> computedStyles;

    /**
     * Whether to include layout object paint orders into the snapshot.
     */
    @Nullable
    private final Boolean includePaintOrder;

    /**
     * Whether to include DOM rectangles (offsetRects, clientRects, scrollRects) into the snapshot
     */
    @Nullable
    private final Boolean includeDOMRects;

    /**
     * Whether to include blended background colors in the snapshot (default: false).
     * Blended background color is achieved by blending background colors of all elements
     * that overlap with the current element.
     */
    @Nullable
    @Experimental
    private final Boolean includeBlendedBackgroundColors;

    /**
     * Whether to include text color opacity in the snapshot (default: false).
     * An element might have the opacity property set that affects the text color of the element.
     * The final text color opacity is computed based on the opacity of all overlapping elements.
     */
    @Nullable
    @Experimental
    private final Boolean includeTextColorOpacities;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CaptureSnapshotResponse {
    /**
     * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
     */
    private final List<DocumentSnapshot> documents;

    /**
     * Shared string table that all string properties refer to with indexes.
     */
    private final List<String> strings;
  }
}
