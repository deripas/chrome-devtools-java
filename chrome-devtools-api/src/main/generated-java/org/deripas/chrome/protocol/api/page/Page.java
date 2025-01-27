package org.deripas.chrome.protocol.api.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.debugger.SearchMatch;
import org.deripas.chrome.protocol.api.dom.Rect;
import org.deripas.chrome.protocol.api.emulation.ScreenOrientation;
import org.deripas.chrome.protocol.api.io.StreamHandle;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextId;

/**
 * Actions and events related to the inspected page belong to the page domain.
 */
@Generated
public interface Page {
  /**
   * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
   */
  @Deprecated
  CompletableFuture<AddScriptToEvaluateOnLoadResponse> addScriptToEvaluateOnLoad(
      AddScriptToEvaluateOnLoadRequest request);

  /**
   * Evaluates given script in every frame upon creation (before loading frame's scripts).
   */
  CompletableFuture<AddScriptToEvaluateOnNewDocumentResponse> addScriptToEvaluateOnNewDocument(
      AddScriptToEvaluateOnNewDocumentRequest request);

  /**
   * Brings page to front (activates tab).
   */
  CompletableFuture<Void> bringToFront();

  /**
   * Capture page screenshot.
   */
  CompletableFuture<CaptureScreenshotResponse> captureScreenshot(CaptureScreenshotRequest request);

  /**
   * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
   * iframes, shadow DOM, external resources, and element-inline styles.
   */
  CompletableFuture<CaptureSnapshotResponse> captureSnapshot(CaptureSnapshotRequest request);

  /**
   * Clears the overridden device metrics.
   */
  @Deprecated
  CompletableFuture<Void> clearDeviceMetricsOverride();

  /**
   * Clears the overridden Device Orientation.
   */
  @Deprecated
  CompletableFuture<Void> clearDeviceOrientationOverride();

  /**
   * Clears the overridden Geolocation Position and Error.
   */
  @Deprecated
  CompletableFuture<Void> clearGeolocationOverride();

  /**
   * Creates an isolated world for the given frame.
   */
  CompletableFuture<CreateIsolatedWorldResponse> createIsolatedWorld(
      CreateIsolatedWorldRequest request);

  /**
   * Deletes browser cookie with given name, domain and path.
   */
  @Deprecated
  CompletableFuture<Void> deleteCookie(DeleteCookieRequest request);

  /**
   * Disables page domain notifications.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables page domain notifications.
   */
  CompletableFuture<Void> enable();

  /**
   * Gets the processed manifest for this current document.
   *   This API always waits for the manifest to be loaded.
   *   If manifestId is provided, and it does not match the manifest of the
   *     current document, this API errors out.
   *   If there is not a loaded page, this API errors out immediately.
   */
  CompletableFuture<GetAppManifestResponse> getAppManifest(GetAppManifestRequest request);

  CompletableFuture<GetInstallabilityErrorsResponse> getInstallabilityErrors();

  /**
   * Deprecated because it's not guaranteed that the returned icon is in fact the one used for PWA installation.
   */
  @Deprecated
  CompletableFuture<GetManifestIconsResponse> getManifestIcons();

  /**
   * Returns the unique (PWA) app id.
   * Only returns values if the feature flag 'WebAppEnableManifestId' is enabled
   */
  CompletableFuture<GetAppIdResponse> getAppId();

  CompletableFuture<GetAdScriptIdResponse> getAdScriptId(GetAdScriptIdRequest request);

  /**
   * Returns present frame tree structure.
   */
  CompletableFuture<GetFrameTreeResponse> getFrameTree();

  /**
   * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
   */
  CompletableFuture<GetLayoutMetricsResponse> getLayoutMetrics();

  /**
   * Returns navigation history for the current page.
   */
  CompletableFuture<GetNavigationHistoryResponse> getNavigationHistory();

  /**
   * Resets navigation history for the current page.
   */
  CompletableFuture<Void> resetNavigationHistory();

  /**
   * Returns content of the given resource.
   */
  CompletableFuture<GetResourceContentResponse> getResourceContent(
      GetResourceContentRequest request);

  /**
   * Returns present frame / resource tree structure.
   */
  CompletableFuture<GetResourceTreeResponse> getResourceTree();

  /**
   * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
   */
  CompletableFuture<Void> handleJavaScriptDialog(HandleJavaScriptDialogRequest request);

  /**
   * Navigates current page to the given URL.
   */
  CompletableFuture<NavigateResponse> navigate(NavigateRequest request);

  /**
   * Navigates current page to the given history entry.
   */
  CompletableFuture<Void> navigateToHistoryEntry(NavigateToHistoryEntryRequest request);

  /**
   * Print page as PDF.
   */
  CompletableFuture<PrintToPDFResponse> printToPDF(PrintToPDFRequest request);

  /**
   * Reloads given page optionally ignoring the cache.
   */
  CompletableFuture<Void> reload(ReloadRequest request);

  /**
   * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
   */
  @Deprecated
  CompletableFuture<Void> removeScriptToEvaluateOnLoad(RemoveScriptToEvaluateOnLoadRequest request);

  /**
   * Removes given script from the list.
   */
  CompletableFuture<Void> removeScriptToEvaluateOnNewDocument(
      RemoveScriptToEvaluateOnNewDocumentRequest request);

  /**
   * Acknowledges that a screencast frame has been received by the frontend.
   */
  CompletableFuture<Void> screencastFrameAck(ScreencastFrameAckRequest request);

  /**
   * Searches for given string in resource content.
   */
  CompletableFuture<SearchInResourceResponse> searchInResource(SearchInResourceRequest request);

  /**
   * Enable Chrome's experimental ad filter on all sites.
   */
  CompletableFuture<Void> setAdBlockingEnabled(SetAdBlockingEnabledRequest request);

  /**
   * Enable page Content Security Policy by-passing.
   */
  CompletableFuture<Void> setBypassCSP(SetBypassCSPRequest request);

  /**
   * Get Permissions Policy state on given frame.
   */
  CompletableFuture<GetPermissionsPolicyStateResponse> getPermissionsPolicyState(
      GetPermissionsPolicyStateRequest request);

  /**
   * Get Origin Trials on given frame.
   */
  CompletableFuture<GetOriginTrialsResponse> getOriginTrials(GetOriginTrialsRequest request);

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
   * window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
   * query results).
   */
  @Deprecated
  CompletableFuture<Void> setDeviceMetricsOverride(SetDeviceMetricsOverrideRequest request);

  /**
   * Overrides the Device Orientation.
   */
  @Deprecated
  CompletableFuture<Void> setDeviceOrientationOverride(SetDeviceOrientationOverrideRequest request);

  /**
   * Set generic font families.
   */
  CompletableFuture<Void> setFontFamilies(SetFontFamiliesRequest request);

  /**
   * Set default font sizes.
   */
  CompletableFuture<Void> setFontSizes(SetFontSizesRequest request);

  /**
   * Sets given markup as the document's HTML.
   */
  CompletableFuture<Void> setDocumentContent(SetDocumentContentRequest request);

  /**
   * Set the behavior when downloading a file.
   */
  @Deprecated
  CompletableFuture<Void> setDownloadBehavior(SetDownloadBehaviorRequest request);

  /**
   * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position
   * unavailable.
   */
  @Deprecated
  CompletableFuture<Void> setGeolocationOverride(SetGeolocationOverrideRequest request);

  /**
   * Controls whether page will emit lifecycle events.
   */
  CompletableFuture<Void> setLifecycleEventsEnabled(SetLifecycleEventsEnabledRequest request);

  /**
   * Toggles mouse event-based touch event emulation.
   */
  @Deprecated
  CompletableFuture<Void> setTouchEmulationEnabled(SetTouchEmulationEnabledRequest request);

  /**
   * Starts sending each frame using the `screencastFrame` event.
   */
  CompletableFuture<Void> startScreencast(StartScreencastRequest request);

  /**
   * Force the page stop all navigations and pending resource fetches.
   */
  CompletableFuture<Void> stopLoading();

  /**
   * Crashes renderer on the IO thread, generates minidumps.
   */
  CompletableFuture<Void> crash();

  /**
   * Tries to close page, running its beforeunload hooks, if any.
   */
  CompletableFuture<Void> close();

  /**
   * Tries to update the web lifecycle state of the page.
   * It will transition the page to the given state according to:
   * https://github.com/WICG/web-lifecycle/
   */
  CompletableFuture<Void> setWebLifecycleState(SetWebLifecycleStateRequest request);

  /**
   * Stops sending each frame in the `screencastFrame`.
   */
  CompletableFuture<Void> stopScreencast();

  /**
   * Requests backend to produce compilation cache for the specified scripts.
   * `scripts` are appended to the list of scripts for which the cache
   * would be produced. The list may be reset during page navigation.
   * When script with a matching URL is encountered, the cache is optionally
   * produced upon backend discretion, based on internal heuristics.
   * See also: `Page.compilationCacheProduced`.
   */
  CompletableFuture<Void> produceCompilationCache(ProduceCompilationCacheRequest request);

  /**
   * Seeds compilation cache for given url. Compilation cache does not survive
   * cross-process navigation.
   */
  CompletableFuture<Void> addCompilationCache(AddCompilationCacheRequest request);

  /**
   * Clears seeded compilation cache.
   */
  CompletableFuture<Void> clearCompilationCache();

  /**
   * Sets the Secure Payment Confirmation transaction mode.
   * https://w3c.github.io/secure-payment-confirmation/#sctn-automation-set-spc-transaction-mode
   */
  CompletableFuture<Void> setSPCTransactionMode(SetSPCTransactionModeRequest request);

  /**
   * Extensions for Custom Handlers API:
   * https://html.spec.whatwg.org/multipage/system-state.html#rph-automation
   */
  CompletableFuture<Void> setRPHRegistrationMode(SetRPHRegistrationModeRequest request);

  /**
   * Generates a report for testing.
   */
  CompletableFuture<Void> generateTestReport(GenerateTestReportRequest request);

  /**
   * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
   */
  CompletableFuture<Void> waitForDebugger();

  /**
   * Intercept file chooser requests and transfer control to protocol clients.
   * When file chooser interception is enabled, native file chooser dialog is not shown.
   * Instead, a protocol event `Page.fileChooserOpened` is emitted.
   */
  CompletableFuture<Void> setInterceptFileChooserDialog(
      SetInterceptFileChooserDialogRequest request);

  /**
   * Enable/disable prerendering manually.
   *
   * This command is a short-term solution for https://crbug.com/1440085.
   * See https://docs.google.com/document/d/12HVmFxYj5Jc-eJr5OmWsa2bqTJsbgGLKI6ZIyx0_wpA
   * for more details.
   *
   * TODO(https://crbug.com/1440085): Remove this once Puppeteer supports tab targets.
   */
  CompletableFuture<Void> setPrerenderingAllowed(SetPrerenderingAllowedRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class AddScriptToEvaluateOnLoadRequest {
    private final String scriptSource;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddScriptToEvaluateOnLoadResponse {
    /**
     * Identifier of the added script.
     */
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddScriptToEvaluateOnNewDocumentRequest {
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
  class AddScriptToEvaluateOnNewDocumentResponse {
    /**
     * Identifier of the added script.
     */
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CaptureScreenshotRequest {
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
  class CaptureScreenshotResponse {
    /**
     * Base64-encoded image data. (Encoded as a base64 string when passed over JSON)
     */
    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CaptureSnapshotRequest {
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
  class CaptureSnapshotResponse {
    /**
     * Serialized page data.
     */
    private final String data;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateIsolatedWorldRequest {
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
  class CreateIsolatedWorldResponse {
    /**
     * Execution context of the isolated world.
     */
    private final ExecutionContextId executionContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DeleteCookieRequest {
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
  class GetAppManifestRequest {
    @Nullable
    private final String manifestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAppManifestResponse {
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
  class GetInstallabilityErrorsResponse {
    private final List<InstallabilityError> installabilityErrors;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetManifestIconsResponse {
    @Nullable
    private final String primaryIcon;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAppIdResponse {
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
  class GetAdScriptIdRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetAdScriptIdResponse {
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
  class GetFrameTreeResponse {
    /**
     * Present frame tree structure.
     */
    private final FrameTree frameTree;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetLayoutMetricsResponse {
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
  class GetNavigationHistoryResponse {
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
  class GetResourceContentRequest {
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
  class GetResourceContentResponse {
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
  class GetResourceTreeResponse {
    /**
     * Present frame / resource tree structure.
     */
    private final FrameResourceTree frameTree;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class HandleJavaScriptDialogRequest {
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
  class NavigateRequest {
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
  class NavigateResponse {
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
  class NavigateToHistoryEntryRequest {
    /**
     * Unique id of the entry to navigate to.
     */
    private final Integer entryId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class PrintToPDFRequest {
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
     * For example, `<span class=title></span>` would generate span containing the title.
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
  class PrintToPDFResponse {
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
  class ReloadRequest {
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
  class RemoveScriptToEvaluateOnLoadRequest {
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveScriptToEvaluateOnNewDocumentRequest {
    private final ScriptIdentifier identifier;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ScreencastFrameAckRequest {
    /**
     * Frame number.
     */
    private final Integer sessionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SearchInResourceRequest {
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
  class SearchInResourceResponse {
    /**
     * List of search matches.
     */
    private final List<SearchMatch> result;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAdBlockingEnabledRequest {
    /**
     * Whether to block ads.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetBypassCSPRequest {
    /**
     * Whether to bypass page CSP.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPermissionsPolicyStateRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetPermissionsPolicyStateResponse {
    private final List<PermissionsPolicyFeatureState> states;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetOriginTrialsRequest {
    private final FrameId frameId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetOriginTrialsResponse {
    private final List<OriginTrial> originTrials;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDeviceMetricsOverrideRequest {
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
  class SetDeviceOrientationOverrideRequest {
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
  class SetFontFamiliesRequest {
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
  class SetFontSizesRequest {
    /**
     * Specifies font sizes to set. If a font size is not specified, it won't be changed.
     */
    private final FontSizes fontSizes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDocumentContentRequest {
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
  class SetDownloadBehaviorRequest {
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
  class SetGeolocationOverrideRequest {
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
  class SetLifecycleEventsEnabledRequest {
    /**
     * If true, starts emitting lifecycle events.
     */
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetTouchEmulationEnabledRequest {
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
  class StartScreencastRequest {
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
  class SetWebLifecycleStateRequest {
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
  class ProduceCompilationCacheRequest {
    private final List<CompilationCacheParams> scripts;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddCompilationCacheRequest {
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
  class SetSPCTransactionModeRequest {
    private final AutoResponseMode mode;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetRPHRegistrationModeRequest {
    private final AutoResponseMode mode;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GenerateTestReportRequest {
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
  class SetInterceptFileChooserDialogRequest {
    private final Boolean enabled;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPrerenderingAllowedRequest {
    private final Boolean isAllowed;
  }
}
