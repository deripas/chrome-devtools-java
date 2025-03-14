package io.github.deripas.chrome.devtools.api.overlay;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * This domain provides various functionality related to drawing atop the inspected page.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Overlay {
  private final Session session;

  /**
   * Disables domain notifications.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Overlay.disable", null, Void.class);
  }

  /**
   * Enables domain notifications.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Overlay.enable", null, Void.class);
  }

  /**
   * For testing.
   */
  public CompletableFuture<GetHighlightObjectForTestResponse> getHighlightObjectForTest(
      GetHighlightObjectForTestRequest request) {
    return session.send("Overlay.getHighlightObjectForTest", request, GetHighlightObjectForTestResponse.class);
  }

  /**
   * For Persistent Grid testing.
   */
  public CompletableFuture<GetGridHighlightObjectsForTestResponse> getGridHighlightObjectsForTest(
      GetGridHighlightObjectsForTestRequest request) {
    return session.send("Overlay.getGridHighlightObjectsForTest", request, GetGridHighlightObjectsForTestResponse.class);
  }

  /**
   * For Source Order Viewer testing.
   */
  public CompletableFuture<GetSourceOrderHighlightObjectForTestResponse> getSourceOrderHighlightObjectForTest(
      GetSourceOrderHighlightObjectForTestRequest request) {
    return session.send("Overlay.getSourceOrderHighlightObjectForTest", request, GetSourceOrderHighlightObjectForTestResponse.class);
  }

  /**
   * Hides any highlight.
   */
  public CompletableFuture<Void> hideHighlight() {
    return session.send("Overlay.hideHighlight", null, Void.class);
  }

  /**
   * Highlights owner element of the frame with given id.
   * Deprecated: Doesn't work reliably and cannot be fixed due to process
   * separation (the owner node might be in a different process). Determine
   * the owner node in the client and use highlightNode.
   */
  @Deprecated
  public CompletableFuture<Void> highlightFrame(HighlightFrameRequest request) {
    return session.send("Overlay.highlightFrame", request, Void.class);
  }

  /**
   * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or
   * objectId must be specified.
   */
  public CompletableFuture<Void> highlightNode(HighlightNodeRequest request) {
    return session.send("Overlay.highlightNode", request, Void.class);
  }

  /**
   * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
   */
  public CompletableFuture<Void> highlightQuad(HighlightQuadRequest request) {
    return session.send("Overlay.highlightQuad", request, Void.class);
  }

  /**
   * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
   */
  public CompletableFuture<Void> highlightRect(HighlightRectRequest request) {
    return session.send("Overlay.highlightRect", request, Void.class);
  }

  /**
   * Highlights the source order of the children of the DOM node with given id or with the given
   * JavaScript object wrapper. Either nodeId or objectId must be specified.
   */
  public CompletableFuture<Void> highlightSourceOrder(HighlightSourceOrderRequest request) {
    return session.send("Overlay.highlightSourceOrder", request, Void.class);
  }

  /**
   * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted.
   * Backend then generates 'inspectNodeRequested' event upon element selection.
   */
  public CompletableFuture<Void> setInspectMode(SetInspectModeRequest request) {
    return session.send("Overlay.setInspectMode", request, Void.class);
  }

  /**
   * Highlights owner element of all frames detected to be ads.
   */
  public CompletableFuture<Void> setShowAdHighlights(SetShowAdHighlightsRequest request) {
    return session.send("Overlay.setShowAdHighlights", request, Void.class);
  }

  public CompletableFuture<Void> setPausedInDebuggerMessage(
      SetPausedInDebuggerMessageRequest request) {
    return session.send("Overlay.setPausedInDebuggerMessage", request, Void.class);
  }

  /**
   * Requests that backend shows debug borders on layers
   */
  public CompletableFuture<Void> setShowDebugBorders(SetShowDebugBordersRequest request) {
    return session.send("Overlay.setShowDebugBorders", request, Void.class);
  }

  /**
   * Requests that backend shows the FPS counter
   */
  public CompletableFuture<Void> setShowFPSCounter(SetShowFPSCounterRequest request) {
    return session.send("Overlay.setShowFPSCounter", request, Void.class);
  }

  /**
   * Highlight multiple elements with the CSS Grid overlay.
   */
  public CompletableFuture<Void> setShowGridOverlays(SetShowGridOverlaysRequest request) {
    return session.send("Overlay.setShowGridOverlays", request, Void.class);
  }

  public CompletableFuture<Void> setShowFlexOverlays(SetShowFlexOverlaysRequest request) {
    return session.send("Overlay.setShowFlexOverlays", request, Void.class);
  }

  public CompletableFuture<Void> setShowScrollSnapOverlays(
      SetShowScrollSnapOverlaysRequest request) {
    return session.send("Overlay.setShowScrollSnapOverlays", request, Void.class);
  }

  public CompletableFuture<Void> setShowContainerQueryOverlays(
      SetShowContainerQueryOverlaysRequest request) {
    return session.send("Overlay.setShowContainerQueryOverlays", request, Void.class);
  }

  /**
   * Requests that backend shows paint rectangles
   */
  public CompletableFuture<Void> setShowPaintRects(SetShowPaintRectsRequest request) {
    return session.send("Overlay.setShowPaintRects", request, Void.class);
  }

  /**
   * Requests that backend shows layout shift regions
   */
  public CompletableFuture<Void> setShowLayoutShiftRegions(
      SetShowLayoutShiftRegionsRequest request) {
    return session.send("Overlay.setShowLayoutShiftRegions", request, Void.class);
  }

  /**
   * Requests that backend shows scroll bottleneck rects
   */
  public CompletableFuture<Void> setShowScrollBottleneckRects(
      SetShowScrollBottleneckRectsRequest request) {
    return session.send("Overlay.setShowScrollBottleneckRects", request, Void.class);
  }

  /**
   * Deprecated, no longer has any effect.
   */
  @Deprecated
  public CompletableFuture<Void> setShowHitTestBorders(SetShowHitTestBordersRequest request) {
    return session.send("Overlay.setShowHitTestBorders", request, Void.class);
  }

  /**
   * Deprecated, no longer has any effect.
   */
  @Deprecated
  public CompletableFuture<Void> setShowWebVitals(SetShowWebVitalsRequest request) {
    return session.send("Overlay.setShowWebVitals", request, Void.class);
  }

  /**
   * Paints viewport size upon main frame resize.
   */
  public CompletableFuture<Void> setShowViewportSizeOnResize(
      SetShowViewportSizeOnResizeRequest request) {
    return session.send("Overlay.setShowViewportSizeOnResize", request, Void.class);
  }

  /**
   * Add a dual screen device hinge
   */
  public CompletableFuture<Void> setShowHinge(SetShowHingeRequest request) {
    return session.send("Overlay.setShowHinge", request, Void.class);
  }

  /**
   * Show elements in isolation mode with overlays.
   */
  public CompletableFuture<Void> setShowIsolatedElements(SetShowIsolatedElementsRequest request) {
    return session.send("Overlay.setShowIsolatedElements", request, Void.class);
  }

  /**
   * Show Window Controls Overlay for PWA
   */
  public CompletableFuture<Void> setShowWindowControlsOverlay(
      SetShowWindowControlsOverlayRequest request) {
    return session.send("Overlay.setShowWindowControlsOverlay", request, Void.class);
  }

  public Disposable onInspectNodeRequested(Consumer<InspectNodeRequestedEvent> listener) {
    return session.subscribe("Overlay.inspectNodeRequested", listener, InspectNodeRequestedEvent.class);
  }

  public Disposable onNodeHighlightRequested(Consumer<NodeHighlightRequestedEvent> listener) {
    return session.subscribe("Overlay.nodeHighlightRequested", listener, NodeHighlightRequestedEvent.class);
  }

  public Disposable onScreenshotRequested(Consumer<ScreenshotRequestedEvent> listener) {
    return session.subscribe("Overlay.screenshotRequested", listener, ScreenshotRequestedEvent.class);
  }

  public Disposable onInspectModeCanceled(Consumer<InspectModeCanceledEvent> listener) {
    return session.subscribe("Overlay.inspectModeCanceled", listener, InspectModeCanceledEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetHighlightObjectForTestRequest {
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
  public static class GetHighlightObjectForTestResponse {
    /**
     * Highlight data for the node.
     */
    private final Map highlight;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetGridHighlightObjectsForTestRequest {
    /**
     * Ids of the node to get highlight object for.
     */
    private final List<NodeId> nodeIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetGridHighlightObjectsForTestResponse {
    /**
     * Grid Highlight data for the node ids provided.
     */
    private final Map highlights;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSourceOrderHighlightObjectForTestRequest {
    /**
     * Id of the node to highlight.
     */
    private final NodeId nodeId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetSourceOrderHighlightObjectForTestResponse {
    /**
     * Source order highlight data for the node id provided.
     */
    private final Map highlight;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class HighlightFrameRequest {
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
  public static class HighlightNodeRequest {
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
  public static class HighlightQuadRequest {
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
  public static class HighlightRectRequest {
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
  public static class HighlightSourceOrderRequest {
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
  public static class SetInspectModeRequest {
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
  public static class SetShowAdHighlightsRequest {
    /**
     * True for showing ad highlights
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetPausedInDebuggerMessageRequest {
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
  public static class SetShowDebugBordersRequest {
    /**
     * True for showing debug borders
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowFPSCounterRequest {
    /**
     * True for showing the FPS counter
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowGridOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<GridNodeHighlightConfig> gridNodeHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowFlexOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<FlexNodeHighlightConfig> flexNodeHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowScrollSnapOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<ScrollSnapHighlightConfig> scrollSnapHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowContainerQueryOverlaysRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<ContainerQueryHighlightConfig> containerQueryHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowPaintRectsRequest {
    /**
     * True for showing paint rectangles
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowLayoutShiftRegionsRequest {
    /**
     * True for showing layout shift regions
     */
    private final Boolean result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowScrollBottleneckRectsRequest {
    /**
     * True for showing scroll bottleneck rects
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowHitTestBordersRequest {
    /**
     * True for showing hit-test borders
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowWebVitalsRequest {
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowViewportSizeOnResizeRequest {
    /**
     * Whether to paint size or not.
     */
    private final Boolean show;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowHingeRequest {
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
  public static class SetShowIsolatedElementsRequest {
    /**
     * An array of node identifiers and descriptors for the highlight appearance.
     */
    private final List<IsolatedElementHighlightConfig> isolatedElementHighlightConfigs;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetShowWindowControlsOverlayRequest {
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
  public static class InspectNodeRequestedEvent {
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
  public static class NodeHighlightRequestedEvent {
    private final NodeId nodeId;
  }

  /**
   * Fired when user asks to capture screenshot of some area on the page.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScreenshotRequestedEvent {
    /**
     * Viewport to capture, in device independent pixels (dip).
     */
    private final Viewport viewport;
  }

  /**
   * Fired when user cancels the inspect mode.
   */
  public static class InspectModeCanceledEvent {
  }
}
