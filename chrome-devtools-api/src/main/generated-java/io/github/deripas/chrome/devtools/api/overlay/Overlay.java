package io.github.deripas.chrome.devtools.api.overlay;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.dom.NodeId;
import io.github.deripas.chrome.devtools.api.dom.Quad;
import io.github.deripas.chrome.devtools.api.dom.RGBA;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import io.github.deripas.chrome.devtools.api.page.Viewport;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObjectId;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain provides various functionality related to drawing atop the inspected page.
 */
@Experimental
@Generated
public interface Overlay {
  /**
   * Disables domain notifications.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables domain notifications.
   */
  CompletableFuture<Void> enable();

  /**
   * For testing.
   */
  CompletableFuture<GetHighlightObjectForTestResponse> getHighlightObjectForTest(
      GetHighlightObjectForTestRequest request);

  /**
   * For Persistent Grid testing.
   */
  CompletableFuture<GetGridHighlightObjectsForTestResponse> getGridHighlightObjectsForTest(
      GetGridHighlightObjectsForTestRequest request);

  /**
   * For Source Order Viewer testing.
   */
  CompletableFuture<GetSourceOrderHighlightObjectForTestResponse> getSourceOrderHighlightObjectForTest(
      GetSourceOrderHighlightObjectForTestRequest request);

  /**
   * Hides any highlight.
   */
  CompletableFuture<Void> hideHighlight();

  /**
   * Highlights owner element of the frame with given id.
   * Deprecated: Doesn't work reliably and cannot be fixed due to process
   * separation (the owner node might be in a different process). Determine
   * the owner node in the client and use highlightNode.
   */
  @Deprecated
  CompletableFuture<Void> highlightFrame(HighlightFrameRequest request);

  /**
   * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
   * objectId must be specified.
   */
  CompletableFuture<Void> highlightNode(HighlightNodeRequest request);

  /**
   * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
   */
  CompletableFuture<Void> highlightQuad(HighlightQuadRequest request);

  /**
   * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
   */
  CompletableFuture<Void> highlightRect(HighlightRectRequest request);

  /**
   * Highlights the source order of the children of the DOM node with given id or with the given
   * JavaScript object wrapper. Either nodeId or objectId must be specified.
   */
  CompletableFuture<Void> highlightSourceOrder(HighlightSourceOrderRequest request);

  /**
   * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
   * Backend then generates 'inspectNodeRequested' event upon element selection.
   */
  CompletableFuture<Void> setInspectMode(SetInspectModeRequest request);

  /**
   * Highlights owner element of all frames detected to be ads.
   */
  CompletableFuture<Void> setShowAdHighlights(SetShowAdHighlightsRequest request);

  CompletableFuture<Void> setPausedInDebuggerMessage(SetPausedInDebuggerMessageRequest request);

  /**
   * Requests that backend shows debug borders on layers
   */
  CompletableFuture<Void> setShowDebugBorders(SetShowDebugBordersRequest request);

  /**
   * Requests that backend shows the FPS counter
   */
  CompletableFuture<Void> setShowFPSCounter(SetShowFPSCounterRequest request);

  /**
   * Highlight multiple elements with the CSS Grid overlay.
   */
  CompletableFuture<Void> setShowGridOverlays(SetShowGridOverlaysRequest request);

  CompletableFuture<Void> setShowFlexOverlays(SetShowFlexOverlaysRequest request);

  CompletableFuture<Void> setShowScrollSnapOverlays(SetShowScrollSnapOverlaysRequest request);

  CompletableFuture<Void> setShowContainerQueryOverlays(
      SetShowContainerQueryOverlaysRequest request);

  /**
   * Requests that backend shows paint rectangles
   */
  CompletableFuture<Void> setShowPaintRects(SetShowPaintRectsRequest request);

  /**
   * Requests that backend shows layout shift regions
   */
  CompletableFuture<Void> setShowLayoutShiftRegions(SetShowLayoutShiftRegionsRequest request);

  /**
   * Requests that backend shows scroll bottleneck rects
   */
  CompletableFuture<Void> setShowScrollBottleneckRects(SetShowScrollBottleneckRectsRequest request);

  /**
   * Deprecated, no longer has any effect.
   */
  @Deprecated
  CompletableFuture<Void> setShowHitTestBorders(SetShowHitTestBordersRequest request);

  /**
   * Deprecated, no longer has any effect.
   */
  @Deprecated
  CompletableFuture<Void> setShowWebVitals(SetShowWebVitalsRequest request);

  /**
   * Paints viewport size upon main frame resize.
   */
  CompletableFuture<Void> setShowViewportSizeOnResize(SetShowViewportSizeOnResizeRequest request);

  /**
   * Add a dual screen device hinge
   */
  CompletableFuture<Void> setShowHinge(SetShowHingeRequest request);

  /**
   * Show elements in isolation mode with overlays.
   */
  CompletableFuture<Void> setShowIsolatedElements(SetShowIsolatedElementsRequest request);

  /**
   * Show Window Controls Overlay for PWA
   */
  CompletableFuture<Void> setShowWindowControlsOverlay(SetShowWindowControlsOverlayRequest request);

  Disposable onInspectNodeRequested(Consumer<InspectNodeRequestedEvent> listener);

  Disposable onNodeHighlightRequested(Consumer<NodeHighlightRequestedEvent> listener);

  Disposable onScreenshotRequested(Consumer<ScreenshotRequestedEvent> listener);

  Disposable onInspectModeCanceled(Consumer<InspectModeCanceledEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHighlightObjectForTestRequest {
    /**
     * Id of the node to get highlight object for.
     */
    private final NodeId nodeId;

    /**
     * Whether to include distance info.
     */
    @Nullable
    private final Boolean includeDistance;

    /**
     * Whether to include style info.
     */
    @Nullable
    private final Boolean includeStyle;

    /**
     * The color format to get config with (default: hex).
     */
    @Nullable
    private final ColorFormat colorFormat;

    /**
     * Whether to show accessibility info (default: true).
     */
    @Nullable
    private final Boolean showAccessibilityInfo;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHighlightObjectForTestResponse {
    /**
     * Highlight data for the node.
     */
    private final Map highlight;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetGridHighlightObjectsForTestRequest {
    /**
     * Ids of the node to get highlight object for.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetGridHighlightObjectsForTestResponse {
    /**
     * Grid Highlight data for the node ids provided.
     */
    private final Map highlights;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSourceOrderHighlightObjectForTestRequest {
    /**
     * Id of the node to highlight.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetSourceOrderHighlightObjectForTestResponse {
    /**
     * Source order highlight data for the node id provided.
     */
    private final Map highlight;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HighlightFrameRequest {
    /**
     * Identifier of the frame to highlight.
     */
    private final FrameId frameId;

    /**
     * The content box highlight fill color (default: transparent).
     */
    @Nullable
    private final RGBA contentColor;

    /**
     * The content box highlight outline color (default: transparent).
     */
    @Nullable
    private final RGBA contentOutlineColor;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HighlightNodeRequest {
    /**
     * A descriptor for the highlight appearance.
     */
    private final HighlightConfig highlightConfig;

    /**
     * Identifier of the node to highlight.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node to highlight.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node to be highlighted.
     */
    @Nullable
    private final RemoteObjectId objectId;

    /**
     * Selectors to highlight relevant nodes.
     */
    @Nullable
    private final String selector;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HighlightQuadRequest {
    /**
     * Quad to highlight
     */
    private final Quad quad;

    /**
     * The highlight fill color (default: transparent).
     */
    @Nullable
    private final RGBA color;

    /**
     * The highlight outline color (default: transparent).
     */
    @Nullable
    private final RGBA outlineColor;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HighlightRectRequest {
    /**
     * X coordinate
     */
    private final Integer x;

    /**
     * Y coordinate
     */
    private final Integer y;

    /**
     * Rectangle width
     */
    private final Integer width;

    /**
     * Rectangle height
     */
    private final Integer height;

    /**
     * The highlight fill color (default: transparent).
     */
    @Nullable
    private final RGBA color;

    /**
     * The highlight outline color (default: transparent).
     */
    @Nullable
    private final RGBA outlineColor;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HighlightSourceOrderRequest {
    /**
     * A descriptor for the appearance of the overlay drawing.
     */
    private final SourceOrderConfig sourceOrderConfig;

    /**
     * Identifier of the node to highlight.
     */
    @Nullable
    private final NodeId nodeId;

    /**
     * Identifier of the backend node to highlight.
     */
    @Nullable
    private final BackendNodeId backendNodeId;

    /**
     * JavaScript object id of the node to be highlighted.
     */
    @Nullable
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetInspectModeRequest {
    /**
     * Set an inspection mode.
     */
    private final InspectMode mode;

    /**
     * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled
     * == false`.
     */
    @Nullable
    private final HighlightConfig highlightConfig;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowAdHighlightsRequest {
    /**
     * True for showing ad highlights
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPausedInDebuggerMessageRequest {
    /**
     * The message to display, also triggers resume and step over controls.
     */
    @Nullable
    private final String message;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowDebugBordersRequest {
    /**
     * True for showing debug borders
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowFPSCounterRequest {
    /**
     * True for showing the FPS counter
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowGridOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<GridNodeHighlightConfig> gridNodeHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowFlexOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<FlexNodeHighlightConfig> flexNodeHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowScrollSnapOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<ScrollSnapHighlightConfig> scrollSnapHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowContainerQueryOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<ContainerQueryHighlightConfig> containerQueryHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowPaintRectsRequest {
    /**
     * True for showing paint rectangles
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowLayoutShiftRegionsRequest {
    /**
     * True for showing layout shift regions
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowScrollBottleneckRectsRequest {
    /**
     * True for showing scroll bottleneck rects
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowHitTestBordersRequest {
    /**
     * True for showing hit-test borders
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowWebVitalsRequest {
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowViewportSizeOnResizeRequest {
    /**
     * Whether to paint size or not.
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowHingeRequest {
    /**
     * hinge data, null means hideHinge
     */
    @Nullable
    private final HingeConfig hingeConfig;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowIsolatedElementsRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<IsolatedElementHighlightConfig> isolatedElementHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetShowWindowControlsOverlayRequest {
    /**
     * Window Controls Overlay data, null means hide Window Controls Overlay
     */
    @Nullable
    private final WindowControlsOverlayConfig windowControlsOverlayConfig;
  }

  /**
   * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
   * user manually inspects an element.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("inspectNodeRequested")
  class InspectNodeRequestedEvent {
    /**
     * Id of the node to inspect.
     */
    private final BackendNodeId backendNodeId;
  }

  /**
   * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("nodeHighlightRequested")
  class NodeHighlightRequestedEvent {
    private final NodeId nodeId;
  }

  /**
   * Fired when user asks to capture screenshot of some area on the page.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("screenshotRequested")
  class ScreenshotRequestedEvent {
    /**
     * Viewport to capture, in device independent pixels (dip).
     */
    private final Viewport viewport;
  }

  /**
   * Fired when user cancels the inspect mode.
   */
  @JsonTypeName("inspectModeCanceled")
  class InspectModeCanceledEvent {
  }
}
