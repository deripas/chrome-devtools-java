package io.github.deripas.chrome.devtools.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.debugger.SearchMatch;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.dom.Rect;
import io.github.deripas.chrome.devtools.api.emulation.ScreenOrientation;
import io.github.deripas.chrome.devtools.api.io.StreamHandle;
import io.github.deripas.chrome.devtools.api.network.LoaderId;
import io.github.deripas.chrome.devtools.api.network.MonotonicTime;
import io.github.deripas.chrome.devtools.api.runtime.ExecutionContextId;
import io.github.deripas.chrome.devtools.api.runtime.StackTrace;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
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
 * Actions and events related to the inspected page belong to the page domain.
 */
@RequiredArgsConstructor
@Generated
public class Page {
  private final Session session;

  /**
   * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
   */
  @Deprecated
  public CompletableFuture<AddScriptToEvaluateOnLoadResponse> addScriptToEvaluateOnLoad(
      AddScriptToEvaluateOnLoadRequest request) {
    return session.send("Page.addScriptToEvaluateOnLoad", request, AddScriptToEvaluateOnLoadResponse.class);
  }

  /**
   * Evaluates given script in every frame upon creation (before loading frame's scripts).
   */
  public CompletableFuture<AddScriptToEvaluateOnNewDocumentResponse> addScriptToEvaluateOnNewDocument(
      AddScriptToEvaluateOnNewDocumentRequest request) {
    return session.send("Page.addScriptToEvaluateOnNewDocument", request, AddScriptToEvaluateOnNewDocumentResponse.class);
  }

  /**
   * Brings page to front (activates tab).
   */
  public CompletableFuture<Void> bringToFront() {
    return session.send("Page.bringToFront", null, Void.class);
  }

  /**
   * Capture page screenshot.
   */
  public CompletableFuture<CaptureScreenshotResponse> captureScreenshot(
      CaptureScreenshotRequest request) {
    return session.send("Page.captureScreenshot", request, CaptureScreenshotResponse.class);
  }

  /**
   * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
   * iframes, shadow DOM, external resources, and element-inline styles.
   */
  public CompletableFuture<CaptureSnapshotResponse> captureSnapshot(
      CaptureSnapshotRequest request) {
    return session.send("Page.captureSnapshot", request, CaptureSnapshotResponse.class);
  }

  /**
   * Clears the overridden device metrics.
   */
  @Deprecated
  public CompletableFuture<Void> clearDeviceMetricsOverride() {
    return session.send("Page.clearDeviceMetricsOverride", null, Void.class);
  }

  /**
   * Clears the overridden Device Orientation.
   */
  @Deprecated
  public CompletableFuture<Void> clearDeviceOrientationOverride() {
    return session.send("Page.clearDeviceOrientationOverride", null, Void.class);
  }

  /**
   * Clears the overridden Geolocation Position and Error.
   */
  @Deprecated
  public CompletableFuture<Void> clearGeolocationOverride() {
    return session.send("Page.clearGeolocationOverride", null, Void.class);
  }

  /**
   * Creates an isolated world for the given frame.
   */
  public CompletableFuture<CreateIsolatedWorldResponse> createIsolatedWorld(
      CreateIsolatedWorldRequest request) {
    return session.send("Page.createIsolatedWorld", request, CreateIsolatedWorldResponse.class);
  }

  /**
   * Deletes browser cookie with given name, domain and path.
   */
  @Deprecated
  public CompletableFuture<Void> deleteCookie(DeleteCookieRequest request) {
    return session.send("Page.deleteCookie", request, Void.class);
  }

  /**
   * Disables page domain notifications.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Page.disable", null, Void.class);
  }

  /**
   * Enables page domain notifications.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Page.enable", null, Void.class);
  }

  /**
   * Gets the processed manifest for this current document.
   *   This API always waits for the manifest to be loaded.
   *   If manifestId is provided, and it does not match the manifest of the
   *     current document, this API errors out.
   *   If there is not a loaded page, this API errors out immediately.
   */
  public CompletableFuture<GetAppManifestResponse> getAppManifest(GetAppManifestRequest request) {
    return session.send("Page.getAppManifest", request, GetAppManifestResponse.class);
  }

  public CompletableFuture<GetInstallabilityErrorsResponse> getInstallabilityErrors() {
    return session.send("Page.getInstallabilityErrors", null, GetInstallabilityErrorsResponse.class);
  }

  /**
   * Deprecated because it's not guaranteed that the returned icon is in fact the one used for PWA installation.
   */
  @Deprecated
  public CompletableFuture<GetManifestIconsResponse> getManifestIcons() {
    return session.send("Page.getManifestIcons", null, GetManifestIconsResponse.class);
  }

  /**
   * Returns the unique (PWA) app id.
   * Only returns values if the feature flag 'WebAppEnableManifestId' is enabled
   */
  public CompletableFuture<GetAppIdResponse> getAppId() {
    return session.send("Page.getAppId", null, GetAppIdResponse.class);
  }

  public CompletableFuture<GetAdScriptIdResponse> getAdScriptId(GetAdScriptIdRequest request) {
    return session.send("Page.getAdScriptId", request, GetAdScriptIdResponse.class);
  }

  /**
   * Returns present frame tree structure.
   */
  public CompletableFuture<GetFrameTreeResponse> getFrameTree() {
    return session.send("Page.getFrameTree", null, GetFrameTreeResponse.class);
  }

  /**
   * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
   */
  public CompletableFuture<GetLayoutMetricsResponse> getLayoutMetrics() {
    return session.send("Page.getLayoutMetrics", null, GetLayoutMetricsResponse.class);
  }

  /**
   * Returns navigation history for the current page.
   */
  public CompletableFuture<GetNavigationHistoryResponse> getNavigationHistory() {
    return session.send("Page.getNavigationHistory", null, GetNavigationHistoryResponse.class);
  }

  /**
   * Resets navigation history for the current page.
   */
  public CompletableFuture<Void> resetNavigationHistory() {
    return session.send("Page.resetNavigationHistory", null, Void.class);
  }

  /**
   * Returns content of the given resource.
   */
  public CompletableFuture<GetResourceContentResponse> getResourceContent(
      GetResourceContentRequest request) {
    return session.send("Page.getResourceContent", request, GetResourceContentResponse.class);
  }

  /**
   * Returns present frame / resource tree structure.
   */
  public CompletableFuture<GetResourceTreeResponse> getResourceTree() {
    return session.send("Page.getResourceTree", null, GetResourceTreeResponse.class);
  }

  /**
   * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
   */
  public CompletableFuture<Void> handleJavaScriptDialog(HandleJavaScriptDialogRequest request) {
    return session.send("Page.handleJavaScriptDialog", request, Void.class);
  }

  /**
   * Navigates current page to the given URL.
   */
  public CompletableFuture<NavigateResponse> navigate(NavigateRequest request) {
    return session.send("Page.navigate", request, NavigateResponse.class);
  }

  /**
   * Navigates current page to the given history entry.
   */
  public CompletableFuture<Void> navigateToHistoryEntry(NavigateToHistoryEntryRequest request) {
    return session.send("Page.navigateToHistoryEntry", request, Void.class);
  }

  /**
   * Print page as PDF.
   */
  public CompletableFuture<PrintToPDFResponse> printToPDF(PrintToPDFRequest request) {
    return session.send("Page.printToPDF", request, PrintToPDFResponse.class);
  }

  /**
   * Reloads given page optionally ignoring the cache.
   */
  public CompletableFuture<Void> reload(ReloadRequest request) {
    return session.send("Page.reload", request, Void.class);
  }

  /**
   * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
   */
  @Deprecated
  public CompletableFuture<Void> removeScriptToEvaluateOnLoad(
      RemoveScriptToEvaluateOnLoadRequest request) {
    return session.send("Page.removeScriptToEvaluateOnLoad", request, Void.class);
  }

  /**
   * Removes given script from the list.
   */
  public CompletableFuture<Void> removeScriptToEvaluateOnNewDocument(
      RemoveScriptToEvaluateOnNewDocumentRequest request) {
    return session.send("Page.removeScriptToEvaluateOnNewDocument", request, Void.class);
  }

  /**
   * Acknowledges that a screencast frame has been received by the frontend.
   */
  public CompletableFuture<Void> screencastFrameAck(ScreencastFrameAckRequest request) {
    return session.send("Page.screencastFrameAck", request, Void.class);
  }

  /**
   * Searches for given string in resource content.
   */
  public CompletableFuture<SearchInResourceResponse> searchInResource(
      SearchInResourceRequest request) {
    return session.send("Page.searchInResource", request, SearchInResourceResponse.class);
  }

  /**
   * Enable Chrome's experimental ad filter on all sites.
   */
  public CompletableFuture<Void> setAdBlockingEnabled(SetAdBlockingEnabledRequest request) {
    return session.send("Page.setAdBlockingEnabled", request, Void.class);
  }

  /**
   * Enable page Content Security Policy by-passing.
   */
  public CompletableFuture<Void> setBypassCSP(SetBypassCSPRequest request) {
    return session.send("Page.setBypassCSP", request, Void.class);
  }

  /**
   * Get Permissions Policy state on given frame.
   */
  public CompletableFuture<GetPermissionsPolicyStateResponse> getPermissionsPolicyState(
      GetPermissionsPolicyStateRequest request) {
    return session.send("Page.getPermissionsPolicyState", request, GetPermissionsPolicyStateResponse.class);
  }

  /**
   * Get Origin Trials on given frame.
   */
  public CompletableFuture<GetOriginTrialsResponse> getOriginTrials(
      GetOriginTrialsRequest request) {
    return session.send("Page.getOriginTrials", request, GetOriginTrialsResponse.class);
  }

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
   * window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
   * query results).
   */
  @Deprecated
  public CompletableFuture<Void> setDeviceMetricsOverride(SetDeviceMetricsOverrideRequest request) {
    return session.send("Page.setDeviceMetricsOverride", request, Void.class);
  }

  /**
   * Overrides the Device Orientation.
   */
  @Deprecated
  public CompletableFuture<Void> setDeviceOrientationOverride(
      SetDeviceOrientationOverrideRequest request) {
    return session.send("Page.setDeviceOrientationOverride", request, Void.class);
  }

  /**
   * Set generic font families.
   */
  public CompletableFuture<Void> setFontFamilies(SetFontFamiliesRequest request) {
    return session.send("Page.setFontFamilies", request, Void.class);
  }

  /**
   * Set default font sizes.
   */
  public CompletableFuture<Void> setFontSizes(SetFontSizesRequest request) {
    return session.send("Page.setFontSizes", request, Void.class);
  }

  /**
   * Sets given markup as the document's HTML.
   */
  public CompletableFuture<Void> setDocumentContent(SetDocumentContentRequest request) {
    return session.send("Page.setDocumentContent", request, Void.class);
  }

  /**
   * Set the behavior when downloading a file.
   */
  @Deprecated
  public CompletableFuture<Void> setDownloadBehavior(SetDownloadBehaviorRequest request) {
    return session.send("Page.setDownloadBehavior", request, Void.class);
  }

  /**
   * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position
   * unavailable.
   */
  @Deprecated
  public CompletableFuture<Void> setGeolocationOverride(SetGeolocationOverrideRequest request) {
    return session.send("Page.setGeolocationOverride", request, Void.class);
  }

  /**
   * Controls whether page will emit lifecycle events.
   */
  public CompletableFuture<Void> setLifecycleEventsEnabled(
      SetLifecycleEventsEnabledRequest request) {
    return session.send("Page.setLifecycleEventsEnabled", request, Void.class);
  }

  /**
   * Toggles mouse event-based touch event emulation.
   */
  @Deprecated
  public CompletableFuture<Void> setTouchEmulationEnabled(SetTouchEmulationEnabledRequest request) {
    return session.send("Page.setTouchEmulationEnabled", request, Void.class);
  }

  /**
   * Starts sending each frame using the `screencastFrame` event.
   */
  public CompletableFuture<Void> startScreencast(StartScreencastRequest request) {
    return session.send("Page.startScreencast", request, Void.class);
  }

  /**
   * Force the page stop all navigations and pending resource fetches.
   */
  public CompletableFuture<Void> stopLoading() {
    return session.send("Page.stopLoading", null, Void.class);
  }

  /**
   * Crashes renderer on the IO thread, generates minidumps.
   */
  public CompletableFuture<Void> crash() {
    return session.send("Page.crash", null, Void.class);
  }

  /**
   * Tries to close page, running its beforeunload hooks, if any.
   */
  public CompletableFuture<Void> close() {
    return session.send("Page.close", null, Void.class);
  }

  /**
   * Tries to update the web lifecycle state of the page.
   * It will transition the page to the given state according to:
   * https://github.com/WICG/web-lifecycle/
   */
  public CompletableFuture<Void> setWebLifecycleState(SetWebLifecycleStateRequest request) {
    return session.send("Page.setWebLifecycleState", request, Void.class);
  }

  /**
   * Stops sending each frame in the `screencastFrame`.
   */
  public CompletableFuture<Void> stopScreencast() {
    return session.send("Page.stopScreencast", null, Void.class);
  }

  /**
   * Requests backend to produce compilation cache for the specified scripts.
   * `scripts` are appended to the list of scripts for which the cache
   * would be produced. The list may be reset during page navigation.
   * When script with a matching URL is encountered, the cache is optionally
   * produced upon backend discretion, based on internal heuristics.
   * See also: `Page.compilationCacheProduced`.
   */
  public CompletableFuture<Void> produceCompilationCache(ProduceCompilationCacheRequest request) {
    return session.send("Page.produceCompilationCache", request, Void.class);
  }

  /**
   * Seeds compilation cache for given url. Compilation cache does not survive
   * cross-process navigation.
   */
  public CompletableFuture<Void> addCompilationCache(AddCompilationCacheRequest request) {
    return session.send("Page.addCompilationCache", request, Void.class);
  }

  /**
   * Clears seeded compilation cache.
   */
  public CompletableFuture<Void> clearCompilationCache() {
    return session.send("Page.clearCompilationCache", null, Void.class);
  }

  /**
   * Sets the Secure Payment Confirmation transaction mode.
   * https://w3c.github.io/secure-payment-confirmation/#sctn-automation-set-spc-transaction-mode
   */
  public CompletableFuture<Void> setSPCTransactionMode(SetSPCTransactionModeRequest request) {
    return session.send("Page.setSPCTransactionMode", request, Void.class);
  }

  /**
   * Extensions for Custom Handlers API:
   * https://html.spec.whatwg.org/multipage/system-state.html#rph-automation
   */
  public CompletableFuture<Void> setRPHRegistrationMode(SetRPHRegistrationModeRequest request) {
    return session.send("Page.setRPHRegistrationMode", request, Void.class);
  }

  /**
   * Generates a report for testing.
   */
  public CompletableFuture<Void> generateTestReport(GenerateTestReportRequest request) {
    return session.send("Page.generateTestReport", request, Void.class);
  }

  /**
   * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
   */
  public CompletableFuture<Void> waitForDebugger() {
    return session.send("Page.waitForDebugger", null, Void.class);
  }

  /**
   * Intercept file chooser requests and transfer control to protocol clients.
   * When file chooser interception is enabled, native file chooser dialog is not shown.
   * Instead, a protocol event `Page.fileChooserOpened` is emitted.
   */
  public CompletableFuture<Void> setInterceptFileChooserDialog(
      SetInterceptFileChooserDialogRequest request) {
    return session.send("Page.setInterceptFileChooserDialog", request, Void.class);
  }

  /**
   * Enable/disable prerendering manually.
   *
   * This command is a short-term solution for https://crbug.com/1440085.
   * See https://docs.google.com/document/d/12HVmFxYj5Jc-eJr5OmWsa2bqTJsbgGLKI6ZIyx0_wpA
   * for more details.
   *
   * TODO(https://crbug.com/1440085): Remove this once Puppeteer supports tab targets.
   */
  public CompletableFuture<Void> setPrerenderingAllowed(SetPrerenderingAllowedRequest request) {
    return session.send("Page.setPrerenderingAllowed", request, Void.class);
  }

  public Disposable onDomContentEventFired(Consumer<DomContentEventFiredEvent> listener) {
    return session.subscribe("Page.domContentEventFired", listener, DomContentEventFiredEvent.class);
  }

  public Disposable onFileChooserOpened(Consumer<FileChooserOpenedEvent> listener) {
    return session.subscribe("Page.fileChooserOpened", listener, FileChooserOpenedEvent.class);
  }

  public Disposable onFrameAttached(Consumer<FrameAttachedEvent> listener) {
    return session.subscribe("Page.frameAttached", listener, FrameAttachedEvent.class);
  }

  public Disposable onFrameClearedScheduledNavigation(
      Consumer<FrameClearedScheduledNavigationEvent> listener) {
    return session.subscribe("Page.frameClearedScheduledNavigation", listener, FrameClearedScheduledNavigationEvent.class);
  }

  public Disposable onFrameDetached(Consumer<FrameDetachedEvent> listener) {
    return session.subscribe("Page.frameDetached", listener, FrameDetachedEvent.class);
  }

  public Disposable onFrameSubtreeWillBeDetached(
      Consumer<FrameSubtreeWillBeDetachedEvent> listener) {
    return session.subscribe("Page.frameSubtreeWillBeDetached", listener, FrameSubtreeWillBeDetachedEvent.class);
  }

  public Disposable onFrameNavigated(Consumer<FrameNavigatedEvent> listener) {
    return session.subscribe("Page.frameNavigated", listener, FrameNavigatedEvent.class);
  }

  public Disposable onDocumentOpened(Consumer<DocumentOpenedEvent> listener) {
    return session.subscribe("Page.documentOpened", listener, DocumentOpenedEvent.class);
  }

  public Disposable onFrameResized(Consumer<FrameResizedEvent> listener) {
    return session.subscribe("Page.frameResized", listener, FrameResizedEvent.class);
  }

  public Disposable onFrameStartedNavigating(Consumer<FrameStartedNavigatingEvent> listener) {
    return session.subscribe("Page.frameStartedNavigating", listener, FrameStartedNavigatingEvent.class);
  }

  public Disposable onFrameRequestedNavigation(Consumer<FrameRequestedNavigationEvent> listener) {
    return session.subscribe("Page.frameRequestedNavigation", listener, FrameRequestedNavigationEvent.class);
  }

  public Disposable onFrameScheduledNavigation(Consumer<FrameScheduledNavigationEvent> listener) {
    return session.subscribe("Page.frameScheduledNavigation", listener, FrameScheduledNavigationEvent.class);
  }

  public Disposable onFrameStartedLoading(Consumer<FrameStartedLoadingEvent> listener) {
    return session.subscribe("Page.frameStartedLoading", listener, FrameStartedLoadingEvent.class);
  }

  public Disposable onFrameStoppedLoading(Consumer<FrameStoppedLoadingEvent> listener) {
    return session.subscribe("Page.frameStoppedLoading", listener, FrameStoppedLoadingEvent.class);
  }

  public Disposable onDownloadWillBegin(Consumer<DownloadWillBeginEvent> listener) {
    return session.subscribe("Page.downloadWillBegin", listener, DownloadWillBeginEvent.class);
  }

  public Disposable onDownloadProgress(Consumer<DownloadProgressEvent> listener) {
    return session.subscribe("Page.downloadProgress", listener, DownloadProgressEvent.class);
  }

  public Disposable onInterstitialHidden(Consumer<InterstitialHiddenEvent> listener) {
    return session.subscribe("Page.interstitialHidden", listener, InterstitialHiddenEvent.class);
  }

  public Disposable onInterstitialShown(Consumer<InterstitialShownEvent> listener) {
    return session.subscribe("Page.interstitialShown", listener, InterstitialShownEvent.class);
  }

  public Disposable onJavascriptDialogClosed(Consumer<JavascriptDialogClosedEvent> listener) {
    return session.subscribe("Page.javascriptDialogClosed", listener, JavascriptDialogClosedEvent.class);
  }

  public Disposable onJavascriptDialogOpening(Consumer<JavascriptDialogOpeningEvent> listener) {
    return session.subscribe("Page.javascriptDialogOpening", listener, JavascriptDialogOpeningEvent.class);
  }

  public Disposable onLifecycleEvent(Consumer<LifecycleEventEvent> listener) {
    return session.subscribe("Page.lifecycleEvent", listener, LifecycleEventEvent.class);
  }

  public Disposable onBackForwardCacheNotUsed(Consumer<BackForwardCacheNotUsedEvent> listener) {
    return session.subscribe("Page.backForwardCacheNotUsed", listener, BackForwardCacheNotUsedEvent.class);
  }

  public Disposable onLoadEventFired(Consumer<LoadEventFiredEvent> listener) {
    return session.subscribe("Page.loadEventFired", listener, LoadEventFiredEvent.class);
  }

  public Disposable onNavigatedWithinDocument(Consumer<NavigatedWithinDocumentEvent> listener) {
    return session.subscribe("Page.navigatedWithinDocument", listener, NavigatedWithinDocumentEvent.class);
  }

  public Disposable onScreencastFrame(Consumer<ScreencastFrameEvent> listener) {
    return session.subscribe("Page.screencastFrame", listener, ScreencastFrameEvent.class);
  }

  public Disposable onScreencastVisibilityChanged(
      Consumer<ScreencastVisibilityChangedEvent> listener) {
    return session.subscribe("Page.screencastVisibilityChanged", listener, ScreencastVisibilityChangedEvent.class);
  }

  public Disposable onWindowOpen(Consumer<WindowOpenEvent> listener) {
    return session.subscribe("Page.windowOpen", listener, WindowOpenEvent.class);
  }

  public Disposable onCompilationCacheProduced(Consumer<CompilationCacheProducedEvent> listener) {
    return session.subscribe("Page.compilationCacheProduced", listener, CompilationCacheProducedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddScriptToEvaluateOnLoadRequest {
    private final String scriptSource;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddScriptToEvaluateOnLoadResponse {
    /**
     * Identifier of the added script.
     */
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddScriptToEvaluateOnNewDocumentRequest {
    private final String source;

    /**
     * If specified, creates an isolated world with the given name and evaluates given script in it.
     * This world name will be used as the ExecutionContextDescription::name when the corresponding
     * event is emitted.
     */
    @Nullable
    @Experimental
    private final String worldName;

    /**
     * Specifies whether command line API should be available to the script, defaults
     * to false.
     */
    @Nullable
    @Experimental
    private final Boolean includeCommandLineAPI;

    /**
     * If true, runs the script immediately on existing execution contexts or worlds.
     * Default: false.
     */
    @Nullable
    @Experimental
    private final Boolean runImmediately;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddScriptToEvaluateOnNewDocumentResponse {
    /**
     * Identifier of the added script.
     */
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CaptureScreenshotRequest {
    /**
     * Image compression format (defaults to png).
     */
    @Nullable
    private final Format format;

    /**
     * Compression quality from range [0..100] (jpeg only).
     */
    @Nullable
    private final Integer quality;

    /**
     * Capture the screenshot of a given region only.
     */
    @Nullable
    private final Viewport clip;

    /**
     * Capture the screenshot from the surface, rather than the view. Defaults to true.
     */
    @Nullable
    @Experimental
    private final Boolean fromSurface;

    /**
     * Capture the screenshot beyond the viewport. Defaults to false.
     */
    @Nullable
    @Experimental
    private final Boolean captureBeyondViewport;

    /**
     * Optimize image encoding for speed, not for resulting size (defaults to false)
     */
    @Nullable
    @Experimental
    private final Boolean optimizeForSpeed;

    public enum Format {
      @JsonProperty("jpeg")
      JPEG,

      @JsonProperty("png")
      PNG,

      @JsonProperty("webp")
      WEBP
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CaptureScreenshotResponse {
    /**
     * Base64-encoded image data. (Encoded as a base64 string when passed over JSON)
     */
    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CaptureSnapshotRequest {
    /**
     * Format (defaults to mhtml).
     */
    @Nullable
    private final Format format;

    public enum Format {
      @JsonProperty("mhtml")
      MHTML
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CaptureSnapshotResponse {
    /**
     * Serialized page data.
     */
    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CreateIsolatedWorldRequest {
    /**
     * Id of the frame in which the isolated world should be created.
     */
    private final FrameId frameId;

    /**
     * An optional name which is reported in the Execution Context.
     */
    @Nullable
    private final String worldName;

    /**
     * Whether or not universal access should be granted to the isolated world. This is a powerful
     * option, use with caution.
     */
    @Nullable
    private final Boolean grantUniveralAccess;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CreateIsolatedWorldResponse {
    /**
     * Execution context of the isolated world.
     */
    private final ExecutionContextId executionContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DeleteCookieRequest {
    /**
     * Name of the cookie to remove.
     */
    private final String cookieName;

    /**
     * URL to match cooke domain and path.
     */
    private final String url;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAppManifestRequest {
    @Nullable
    private final String manifestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAppManifestResponse {
    /**
     * Manifest location.
     */
    private final String url;

    private final List<AppManifestError> errors;

    /**
     * Manifest content.
     */
    @Nullable
    private final String data;

    /**
     * Parsed manifest properties. Deprecated, use manifest instead.
     */
    @Nullable
    @Experimental
    @Deprecated
    private final AppManifestParsedProperties parsed;

    @Experimental
    private final WebAppManifest manifest;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetInstallabilityErrorsResponse {
    private final List<InstallabilityError> installabilityErrors;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetManifestIconsResponse {
    @Nullable
    private final String primaryIcon;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAppIdResponse {
    /**
     * App id, either from manifest's id attribute or computed from start_url
     */
    @Nullable
    private final String appId;

    /**
     * Recommendation for manifest's id attribute to match current id computed from start_url
     */
    @Nullable
    private final String recommendedId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAdScriptIdRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetAdScriptIdResponse {
    /**
     * Identifies the bottom-most script which caused the frame to be labelled
     * as an ad. Only sent if frame is labelled as an ad and id is available.
     */
    @Nullable
    private final AdScriptId adScriptId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetFrameTreeResponse {
    /**
     * Present frame tree structure.
     */
    private final FrameTree frameTree;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetLayoutMetricsResponse {
    /**
     * Deprecated metrics relating to the layout viewport. Is in device pixels. Use `cssLayoutViewport` instead.
     */
    @Deprecated
    private final LayoutViewport layoutViewport;

    /**
     * Deprecated metrics relating to the visual viewport. Is in device pixels. Use `cssVisualViewport` instead.
     */
    @Deprecated
    private final VisualViewport visualViewport;

    /**
     * Deprecated size of scrollable area. Is in DP. Use `cssContentSize` instead.
     */
    @Deprecated
    private final Rect contentSize;

    /**
     * Metrics relating to the layout viewport in CSS pixels.
     */
    private final LayoutViewport cssLayoutViewport;

    /**
     * Metrics relating to the visual viewport in CSS pixels.
     */
    private final VisualViewport cssVisualViewport;

    /**
     * Size of scrollable area in CSS pixels.
     */
    private final Rect cssContentSize;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetNavigationHistoryResponse {
    /**
     * Index of the current navigation history entry.
     */
    private final Integer currentIndex;

    /**
     * Array of navigation history entries.
     */
    private final List<NavigationEntry> entries;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResourceContentRequest {
    /**
     * Frame id to get resource for.
     */
    private final FrameId frameId;

    /**
     * URL of the resource to get content for.
     */
    private final String url;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResourceContentResponse {
    /**
     * Resource content.
     */
    private final String content;

    /**
     * True, if content was served as base64.
     */
    private final Boolean base64Encoded;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetResourceTreeResponse {
    /**
     * Present frame / resource tree structure.
     */
    private final FrameResourceTree frameTree;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class HandleJavaScriptDialogRequest {
    /**
     * Whether to accept or dismiss the dialog.
     */
    private final Boolean accept;

    /**
     * The text to enter into the dialog prompt before accepting. Used only if this is a prompt
     * dialog.
     */
    @Nullable
    private final String promptText;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class NavigateRequest {
    /**
     * URL to navigate the page to.
     */
    private final String url;

    /**
     * Referrer URL.
     */
    @Nullable
    private final String referrer;

    /**
     * Intended transition type.
     */
    @Nullable
    private final TransitionType transitionType;

    /**
     * Frame id to navigate, if not specified navigates the top frame.
     */
    @Nullable
    private final FrameId frameId;

    /**
     * Referrer-policy used for the navigation.
     */
    @Nullable
    @Experimental
    private final ReferrerPolicy referrerPolicy;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class NavigateResponse {
    /**
     * Frame id that has navigated (or failed to navigate)
     */
    private final FrameId frameId;

    /**
     * Loader identifier. This is omitted in case of same-document navigation,
     * as the previously committed loaderId would not change.
     */
    @Nullable
    private final LoaderId loaderId;

    /**
     * User friendly error message, present if and only if navigation has failed.
     */
    @Nullable
    private final String errorText;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class NavigateToHistoryEntryRequest {
    /**
     * Unique id of the entry to navigate to.
     */
    private final Integer entryId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PrintToPDFRequest {
    /**
     * Paper orientation. Defaults to false.
     */
    @Nullable
    private final Boolean landscape;

    /**
     * Display header and footer. Defaults to false.
     */
    @Nullable
    private final Boolean displayHeaderFooter;

    /**
     * Print background graphics. Defaults to false.
     */
    @Nullable
    private final Boolean printBackground;

    /**
     * Scale of the webpage rendering. Defaults to 1.
     */
    @Nullable
    private final Double scale;

    /**
     * Paper width in inches. Defaults to 8.5 inches.
     */
    @Nullable
    private final Double paperWidth;

    /**
     * Paper height in inches. Defaults to 11 inches.
     */
    @Nullable
    private final Double paperHeight;

    /**
     * Top margin in inches. Defaults to 1cm (~0.4 inches).
     */
    @Nullable
    private final Double marginTop;

    /**
     * Bottom margin in inches. Defaults to 1cm (~0.4 inches).
     */
    @Nullable
    private final Double marginBottom;

    /**
     * Left margin in inches. Defaults to 1cm (~0.4 inches).
     */
    @Nullable
    private final Double marginLeft;

    /**
     * Right margin in inches. Defaults to 1cm (~0.4 inches).
     */
    @Nullable
    private final Double marginRight;

    /**
     * Paper ranges to print, one based, e.g., '1-5, 8, 11-13'. Pages are
     * printed in the document order, not in the order specified, and no
     * more than once.
     * Defaults to empty string, which implies the entire document is printed.
     * The page numbers are quietly capped to actual page count of the
     * document, and ranges beyond the end of the document are ignored.
     * If this results in no pages to print, an error is reported.
     * It is an error to specify a range with start greater than end.
     */
    @Nullable
    private final String pageRanges;

    /**
     * HTML template for the print header. Should be valid HTML markup with following
     * classes used to inject printing values into them:
     * - `date`: formatted print date
     * - `title`: document title
     * - `url`: document location
     * - `pageNumber`: current page number
     * - `totalPages`: total pages in the document
     *
     * For example, `&lt;span class=title&gt;&lt;/span&gt;` would generate span containing the title.
     */
    @Nullable
    private final String headerTemplate;

    /**
     * HTML template for the print footer. Should use the same format as the `headerTemplate`.
     */
    @Nullable
    private final String footerTemplate;

    /**
     * Whether or not to prefer page size as defined by css. Defaults to false,
     * in which case the content will be scaled to fit the paper size.
     */
    @Nullable
    private final Boolean preferCSSPageSize;

    /**
     * return as stream
     */
    @Nullable
    @Experimental
    private final TransferMode transferMode;

    /**
     * Whether or not to generate tagged (accessible) PDF. Defaults to embedder choice.
     */
    @Nullable
    @Experimental
    private final Boolean generateTaggedPDF;

    /**
     * Whether or not to embed the document outline into the PDF.
     */
    @Nullable
    @Experimental
    private final Boolean generateDocumentOutline;

    public enum TransferMode {
      @JsonProperty("ReturnAsBase64")
      RETURN_AS_BASE64,

      @JsonProperty("ReturnAsStream")
      RETURN_AS_STREAM
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class PrintToPDFResponse {
    /**
     * Base64-encoded pdf data. Empty if |returnAsStream| is specified. (Encoded as a base64 string when passed over JSON)
     */
    private final String data;

    /**
     * A handle of the stream that holds resulting PDF data.
     */
    @Nullable
    @Experimental
    private final StreamHandle stream;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReloadRequest {
    /**
     * If true, browser cache is ignored (as if the user pressed Shift+refresh).
     */
    @Nullable
    private final Boolean ignoreCache;

    /**
     * If set, the script will be injected into all frames of the inspected page after reload.
     * Argument will be ignored if reloading dataURL origin.
     */
    @Nullable
    private final String scriptToEvaluateOnLoad;

    /**
     * If set, an error will be thrown if the target page's main frame's
     * loader id does not match the provided id. This prevents accidentally
     * reloading an unintended target in case there's a racing navigation.
     */
    @Nullable
    @Experimental
    private final LoaderId loaderId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveScriptToEvaluateOnLoadRequest {
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveScriptToEvaluateOnNewDocumentRequest {
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScreencastFrameAckRequest {
    /**
     * Frame number.
     */
    private final Integer sessionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SearchInResourceRequest {
    /**
     * Frame id for resource to search in.
     */
    private final FrameId frameId;

    /**
     * URL of the resource to search in.
     */
    private final String url;

    /**
     * String to search for.
     */
    private final String query;

    /**
     * If true, search is case sensitive.
     */
    @Nullable
    private final Boolean caseSensitive;

    /**
     * If true, treats string parameter as regex.
     */
    @Nullable
    private final Boolean isRegex;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SearchInResourceResponse {
    /**
     * List of search matches.
     */
    private final List<SearchMatch> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetAdBlockingEnabledRequest {
    /**
     * Whether to block ads.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBypassCSPRequest {
    /**
     * Whether to bypass page CSP.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetPermissionsPolicyStateRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetPermissionsPolicyStateResponse {
    private final List<PermissionsPolicyFeatureState> states;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetOriginTrialsRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetOriginTrialsResponse {
    private final List<OriginTrial> originTrials;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDeviceMetricsOverrideRequest {
    /**
     * Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    private final Integer width;

    /**
     * Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     */
    private final Integer height;

    /**
     * Overriding device scale factor value. 0 disables the override.
     */
    private final Double deviceScaleFactor;

    /**
     * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text
     * autosizing and more.
     */
    private final Boolean mobile;

    /**
     * Scale to apply to resulting view image.
     */
    @Nullable
    private final Double scale;

    /**
     * Overriding screen width value in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    private final Integer screenWidth;

    /**
     * Overriding screen height value in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    private final Integer screenHeight;

    /**
     * Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    private final Integer positionX;

    /**
     * Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
     */
    @Nullable
    private final Integer positionY;

    /**
     * Do not set visible view size, rely upon explicit setVisibleSize call.
     */
    @Nullable
    private final Boolean dontSetVisibleSize;

    /**
     * Screen orientation override.
     */
    @Nullable
    private final ScreenOrientation screenOrientation;

    /**
     * The viewport dimensions and scale. If not set, the override is cleared.
     */
    @Nullable
    private final Viewport viewport;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDeviceOrientationOverrideRequest {
    /**
     * Mock alpha
     */
    private final Double alpha;

    /**
     * Mock beta
     */
    private final Double beta;

    /**
     * Mock gamma
     */
    private final Double gamma;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetFontFamiliesRequest {
    /**
     * Specifies font families to set. If a font family is not specified, it won't be changed.
     */
    private final FontFamilies fontFamilies;

    /**
     * Specifies font families to set for individual scripts.
     */
    @Nullable
    private final List<ScriptFontFamilies> forScripts;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetFontSizesRequest {
    /**
     * Specifies font sizes to set. If a font size is not specified, it won't be changed.
     */
    private final FontSizes fontSizes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDocumentContentRequest {
    /**
     * Frame id to set HTML for.
     */
    private final FrameId frameId;

    /**
     * HTML content to set.
     */
    private final String html;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDownloadBehaviorRequest {
    /**
     * Whether to allow all or deny all download requests, or use default Chrome behavior if
     * available (otherwise deny).
     */
    private final Behavior behavior;

    /**
     * The default path to save downloaded files to. This is required if behavior is set to 'allow'
     */
    @Nullable
    private final String downloadPath;

    public enum Behavior {
      @JsonProperty("deny")
      DENY,

      @JsonProperty("allow")
      ALLOW,

      @JsonProperty("default")
      DEFAULT
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetGeolocationOverrideRequest {
    /**
     * Mock latitude
     */
    @Nullable
    private final Double latitude;

    /**
     * Mock longitude
     */
    @Nullable
    private final Double longitude;

    /**
     * Mock accuracy
     */
    @Nullable
    private final Double accuracy;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetLifecycleEventsEnabledRequest {
    /**
     * If true, starts emitting lifecycle events.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetTouchEmulationEnabledRequest {
    /**
     * Whether the touch event emulation should be enabled.
     */
    private final Boolean enabled;

    /**
     * Touch/gesture events configuration. Default: current platform.
     */
    @Nullable
    private final Configuration configuration;

    public enum Configuration {
      @JsonProperty("mobile")
      MOBILE,

      @JsonProperty("desktop")
      DESKTOP
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartScreencastRequest {
    /**
     * Image compression format.
     */
    @Nullable
    private final Format format;

    /**
     * Compression quality from range [0..100].
     */
    @Nullable
    private final Integer quality;

    /**
     * Maximum screenshot width.
     */
    @Nullable
    private final Integer maxWidth;

    /**
     * Maximum screenshot height.
     */
    @Nullable
    private final Integer maxHeight;

    /**
     * Send every n-th frame.
     */
    @Nullable
    private final Integer everyNthFrame;

    public enum Format {
      @JsonProperty("jpeg")
      JPEG,

      @JsonProperty("png")
      PNG
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetWebLifecycleStateRequest {
    /**
     * Target lifecycle state
     */
    private final State state;

    public enum State {
      @JsonProperty("frozen")
      FROZEN,

      @JsonProperty("active")
      ACTIVE
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ProduceCompilationCacheRequest {
    private final List<CompilationCacheParams> scripts;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddCompilationCacheRequest {
    private final String url;

    /**
     * Base64-encoded data (Encoded as a base64 string when passed over JSON)
     */
    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSPCTransactionModeRequest {
    private final AutoResponseMode mode;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetRPHRegistrationModeRequest {
    private final AutoResponseMode mode;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GenerateTestReportRequest {
    /**
     * Message to be displayed in the report.
     */
    private final String message;

    /**
     * Specifies the endpoint group to deliver the report to.
     */
    @Nullable
    private final String group;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInterceptFileChooserDialogRequest {
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetPrerenderingAllowedRequest {
    private final Boolean isAllowed;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DomContentEventFiredEvent {
    private final MonotonicTime timestamp;
  }

  /**
   * Emitted only when `page.interceptFileChooser` is enabled.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FileChooserOpenedEvent {
    /**
     * Id of the frame containing input node.
     */
    @Experimental
    private final FrameId frameId;

    /**
     * Input mode.
     */
    private final Mode mode;

    /**
     * Input node id. Only present for file choosers opened via an `&lt;input type="file"&gt;` element.
     */
    @Nullable
    @Experimental
    private final BackendNodeId backendNodeId;

    public enum Mode {
      @JsonProperty("selectSingle")
      SELECT_SINGLE,

      @JsonProperty("selectMultiple")
      SELECT_MULTIPLE
    }
  }

  /**
   * Fired when frame has been attached to its parent.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameAttachedEvent {
    /**
     * Id of the frame that has been attached.
     */
    private final FrameId frameId;

    /**
     * Parent frame identifier.
     */
    private final FrameId parentFrameId;

    /**
     * JavaScript stack trace of when frame was attached, only set if frame initiated from script.
     */
    @Nullable
    private final StackTrace stack;
  }

  /**
   * Fired when frame no longer has a scheduled navigation.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameClearedScheduledNavigationEvent {
    /**
     * Id of the frame that has cleared its scheduled navigation.
     */
    private final FrameId frameId;
  }

  /**
   * Fired when frame has been detached from its parent.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameDetachedEvent {
    /**
     * Id of the frame that has been detached.
     */
    private final FrameId frameId;

    @Experimental
    private final Reason reason;

    public enum Reason {
      @JsonProperty("remove")
      REMOVE,

      @JsonProperty("swap")
      SWAP
    }
  }

  /**
   * Fired before frame subtree is detached. Emitted before any frame of the
   * subtree is actually detached.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameSubtreeWillBeDetachedEvent {
    /**
     * Id of the frame that is the root of the subtree that will be detached.
     */
    private final FrameId frameId;
  }

  /**
   * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameNavigatedEvent {
    /**
     * Frame object.
     */
    private final Frame frame;

    @Experimental
    private final NavigationType type;
  }

  /**
   * Fired when opening document to write to.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DocumentOpenedEvent {
    /**
     * Frame object.
     */
    private final Frame frame;
  }

  public static class FrameResizedEvent {
  }

  /**
   * Fired when a navigation starts. This event is fired for both
   * renderer-initiated and browser-initiated navigations. For renderer-initiated
   * navigations, the event is fired after `frameRequestedNavigation`.
   * Navigation may still be cancelled after the event is issued. Multiple events
   * can be fired for a single navigation, for example, when a same-document
   * navigation becomes a cross-document navigation (such as in the case of a
   * frameset).
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameStartedNavigatingEvent {
    /**
     * ID of the frame that is being navigated.
     */
    private final FrameId frameId;

    /**
     * The URL the navigation started with. The final URL can be different.
     */
    private final String url;

    /**
     * Loader identifier. Even though it is present in case of same-document
     * navigation, the previously committed loaderId would not change unless
     * the navigation changes from a same-document to a cross-document
     * navigation.
     */
    private final LoaderId loaderId;

    private final NavigationType navigationType;

    public enum NavigationType {
      @JsonProperty("reload")
      RELOAD,

      @JsonProperty("reloadBypassingCache")
      RELOAD_BYPASSING_CACHE,

      @JsonProperty("restore")
      RESTORE,

      @JsonProperty("restoreWithPost")
      RESTORE_WITH_POST,

      @JsonProperty("historySameDocument")
      HISTORY_SAME_DOCUMENT,

      @JsonProperty("historyDifferentDocument")
      HISTORY_DIFFERENT_DOCUMENT,

      @JsonProperty("sameDocument")
      SAME_DOCUMENT,

      @JsonProperty("differentDocument")
      DIFFERENT_DOCUMENT
    }
  }

  /**
   * Fired when a renderer-initiated navigation is requested.
   * Navigation may still be cancelled after the event is issued.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameRequestedNavigationEvent {
    /**
     * Id of the frame that is being navigated.
     */
    private final FrameId frameId;

    /**
     * The reason for the navigation.
     */
    private final ClientNavigationReason reason;

    /**
     * The destination URL for the requested navigation.
     */
    private final String url;

    /**
     * The disposition for the navigation.
     */
    private final ClientNavigationDisposition disposition;
  }

  /**
   * Fired when frame schedules a potential navigation.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameScheduledNavigationEvent {
    /**
     * Id of the frame that has scheduled a navigation.
     */
    private final FrameId frameId;

    /**
     * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not
     * guaranteed to start.
     */
    private final Double delay;

    /**
     * The reason for the navigation.
     */
    private final ClientNavigationReason reason;

    /**
     * The destination URL for the scheduled navigation.
     */
    private final String url;
  }

  /**
   * Fired when frame has started loading.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameStartedLoadingEvent {
    /**
     * Id of the frame that has started loading.
     */
    private final FrameId frameId;
  }

  /**
   * Fired when frame has stopped loading.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class FrameStoppedLoadingEvent {
    /**
     * Id of the frame that has stopped loading.
     */
    private final FrameId frameId;
  }

  /**
   * Fired when page is about to start a download.
   * Deprecated. Use Browser.downloadWillBegin instead.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DownloadWillBeginEvent {
    /**
     * Id of the frame that caused download to begin.
     */
    private final FrameId frameId;

    /**
     * Global unique identifier of the download.
     */
    private final String guid;

    /**
     * URL of the resource being downloaded.
     */
    private final String url;

    /**
     * Suggested file name of the resource (the actual name of the file saved on disk may differ).
     */
    private final String suggestedFilename;
  }

  /**
   * Fired when download makes progress. Last call has |done| == true.
   * Deprecated. Use Browser.downloadProgress instead.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DownloadProgressEvent {
    /**
     * Global unique identifier of the download.
     */
    private final String guid;

    /**
     * Total expected bytes to download.
     */
    private final Double totalBytes;

    /**
     * Total bytes received.
     */
    private final Double receivedBytes;

    /**
     * Download status.
     */
    private final State state;

    public enum State {
      @JsonProperty("inProgress")
      IN_PROGRESS,

      @JsonProperty("completed")
      COMPLETED,

      @JsonProperty("canceled")
      CANCELED
    }
  }

  /**
   * Fired when interstitial page was hidden
   */
  public static class InterstitialHiddenEvent {
  }

  /**
   * Fired when interstitial page was shown
   */
  public static class InterstitialShownEvent {
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
   * closed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class JavascriptDialogClosedEvent {
    /**
     * Whether dialog was confirmed.
     */
    private final Boolean result;

    /**
     * User input in case of prompt.
     */
    private final String userInput;
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
   * open.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class JavascriptDialogOpeningEvent {
    /**
     * Frame url.
     */
    private final String url;

    /**
     * Message that will be displayed by the dialog.
     */
    private final String message;

    /**
     * Dialog type.
     */
    private final DialogType type;

    /**
     * True iff browser is capable showing or acting on the given dialog. When browser has no
     * dialog handler for given target, calling alert while Page domain is engaged will stall
     * the page execution. Execution can be resumed via calling Page.handleJavaScriptDialog.
     */
    private final Boolean hasBrowserHandler;

    /**
     * Default dialog prompt.
     */
    @Nullable
    private final String defaultPrompt;
  }

  /**
   * Fired for lifecycle events (navigation, load, paint, etc) in the current
   * target (including local frames).
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class LifecycleEventEvent {
    /**
     * Id of the frame.
     */
    private final FrameId frameId;

    /**
     * Loader identifier. Empty string if the request is fetched from worker.
     */
    private final LoaderId loaderId;

    private final String name;

    private final MonotonicTime timestamp;
  }

  /**
   * Fired for failed bfcache history navigations if BackForwardCache feature is enabled. Do
   * not assume any ordering with the Page.frameNavigated event. This event is fired only for
   * main-frame history navigation where the document changes (non-same-document navigations),
   * when bfcache navigation fails.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class BackForwardCacheNotUsedEvent {
    /**
     * The loader id for the associated navigation.
     */
    private final LoaderId loaderId;

    /**
     * The frame id of the associated frame.
     */
    private final FrameId frameId;

    /**
     * Array of reasons why the page could not be cached. This must not be empty.
     */
    private final List<BackForwardCacheNotRestoredExplanation> notRestoredExplanations;

    /**
     * Tree structure of reasons why the page could not be cached for each frame.
     */
    @Nullable
    private final BackForwardCacheNotRestoredExplanationTree notRestoredExplanationsTree;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LoadEventFiredEvent {
    private final MonotonicTime timestamp;
  }

  /**
   * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class NavigatedWithinDocumentEvent {
    /**
     * Id of the frame.
     */
    private final FrameId frameId;

    /**
     * Frame's new url.
     */
    private final String url;

    /**
     * Navigation type
     */
    private final NavigationType navigationType;

    public enum NavigationType {
      @JsonProperty("fragment")
      FRAGMENT,

      @JsonProperty("historyApi")
      HISTORY_API,

      @JsonProperty("other")
      OTHER
    }
  }

  /**
   * Compressed image data requested by the `startScreencast`.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScreencastFrameEvent {
    /**
     * Base64-encoded compressed image. (Encoded as a base64 string when passed over JSON)
     */
    private final String data;

    /**
     * Screencast frame metadata.
     */
    private final ScreencastFrameMetadata metadata;

    /**
     * Frame number.
     */
    private final Integer sessionId;
  }

  /**
   * Fired when the page with currently enabled screencast was shown or hidden `.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ScreencastVisibilityChangedEvent {
    /**
     * True if the page is visible.
     */
    private final Boolean visible;
  }

  /**
   * Fired when a new window is going to be opened, via window.open(), link click, form submission,
   * etc.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class WindowOpenEvent {
    /**
     * The URL for the new window.
     */
    private final String url;

    /**
     * Window name.
     */
    private final String windowName;

    /**
     * An array of enabled window features.
     */
    private final List<String> windowFeatures;

    /**
     * Whether or not it was triggered by user gesture.
     */
    private final Boolean userGesture;
  }

  /**
   * Issued for every compilation cache generated. Is only available
   * if Page.setGenerateCompilationCache is enabled.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class CompilationCacheProducedEvent {
    private final String url;

    /**
     * Base64-encoded data (Encoded as a base64 string when passed over JSON)
     */
    private final String data;
  }
}
