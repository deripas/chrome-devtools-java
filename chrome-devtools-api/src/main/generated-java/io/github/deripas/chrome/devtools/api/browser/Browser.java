package io.github.deripas.chrome.devtools.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import io.github.deripas.chrome.devtools.api.target.TargetID;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * The Browser domain defines methods and events for browser managing.
 */
@RequiredArgsConstructor
@Generated
public class Browser {
  private final Session session;

  /**
   * Set permission settings for given origin.
   */
  public CompletableFuture<Void> setPermission(SetPermissionRequest request) {
    return session.send("Browser.setPermission", request, Void.class);
  }

  /**
   * Grant specific permissions to the given origin and reject all others.
   */
  public CompletableFuture<Void> grantPermissions(GrantPermissionsRequest request) {
    return session.send("Browser.grantPermissions", request, Void.class);
  }

  /**
   * Reset all permission management for all origins.
   */
  public CompletableFuture<Void> resetPermissions(ResetPermissionsRequest request) {
    return session.send("Browser.resetPermissions", request, Void.class);
  }

  /**
   * Set the behavior when downloading a file.
   */
  public CompletableFuture<Void> setDownloadBehavior(SetDownloadBehaviorRequest request) {
    return session.send("Browser.setDownloadBehavior", request, Void.class);
  }

  /**
   * Cancel a download if in progress
   */
  public CompletableFuture<Void> cancelDownload(CancelDownloadRequest request) {
    return session.send("Browser.cancelDownload", request, Void.class);
  }

  /**
   * Close browser gracefully.
   */
  public CompletableFuture<Void> close() {
    return session.send("Browser.close", null, Void.class);
  }

  /**
   * Crashes browser on the main thread.
   */
  public CompletableFuture<Void> crash() {
    return session.send("Browser.crash", null, Void.class);
  }

  /**
   * Crashes GPU process.
   */
  public CompletableFuture<Void> crashGpuProcess() {
    return session.send("Browser.crashGpuProcess", null, Void.class);
  }

  /**
   * Returns version information.
   */
  public CompletableFuture<GetVersionResponse> getVersion() {
    return session.send("Browser.getVersion", null, GetVersionResponse.class);
  }

  /**
   * Returns the command line switches for the browser process if, and only if
   * --enable-automation is on the commandline.
   */
  public CompletableFuture<GetBrowserCommandLineResponse> getBrowserCommandLine() {
    return session.send("Browser.getBrowserCommandLine", null, GetBrowserCommandLineResponse.class);
  }

  /**
   * Get Chrome histograms.
   */
  public CompletableFuture<GetHistogramsResponse> getHistograms(GetHistogramsRequest request) {
    return session.send("Browser.getHistograms", request, GetHistogramsResponse.class);
  }

  /**
   * Get a Chrome histogram by name.
   */
  public CompletableFuture<GetHistogramResponse> getHistogram(GetHistogramRequest request) {
    return session.send("Browser.getHistogram", request, GetHistogramResponse.class);
  }

  /**
   * Get position and size of the browser window.
   */
  public CompletableFuture<GetWindowBoundsResponse> getWindowBounds(
      GetWindowBoundsRequest request) {
    return session.send("Browser.getWindowBounds", request, GetWindowBoundsResponse.class);
  }

  /**
   * Get the browser window that contains the devtools target.
   */
  public CompletableFuture<GetWindowForTargetResponse> getWindowForTarget(
      GetWindowForTargetRequest request) {
    return session.send("Browser.getWindowForTarget", request, GetWindowForTargetResponse.class);
  }

  /**
   * Set position and/or size of the browser window.
   */
  public CompletableFuture<Void> setWindowBounds(SetWindowBoundsRequest request) {
    return session.send("Browser.setWindowBounds", request, Void.class);
  }

  /**
   * Set dock tile details, platform-specific.
   */
  public CompletableFuture<Void> setDockTile(SetDockTileRequest request) {
    return session.send("Browser.setDockTile", request, Void.class);
  }

  /**
   * Invoke custom browser commands used by telemetry.
   */
  public CompletableFuture<Void> executeBrowserCommand(ExecuteBrowserCommandRequest request) {
    return session.send("Browser.executeBrowserCommand", request, Void.class);
  }

  /**
   * Allows a site to use privacy sandbox features that require enrollment
   * without the site actually being enrolled. Only supported on page targets.
   */
  public CompletableFuture<Void> addPrivacySandboxEnrollmentOverride(
      AddPrivacySandboxEnrollmentOverrideRequest request) {
    return session.send("Browser.addPrivacySandboxEnrollmentOverride", request, Void.class);
  }

  public Disposable onDownloadWillBegin(Consumer<DownloadWillBeginEvent> listener) {
    return session.subscribe("Browser.downloadWillBegin", listener, DownloadWillBeginEvent.class);
  }

  public Disposable onDownloadProgress(Consumer<DownloadProgressEvent> listener) {
    return session.subscribe("Browser.downloadProgress", listener, DownloadProgressEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetPermissionRequest {
    /**
     * Descriptor of permission to override.
     */
    private final PermissionDescriptor permission;

    /**
     * Setting of the permission.
     */
    private final PermissionSetting setting;

    /**
     * Origin the permission applies to, all origins if not specified.
     */
    @Nullable
    private final String origin;

    /**
     * Context to override. When omitted, default browser context is used.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GrantPermissionsRequest {
    private final List<PermissionType> permissions;

    /**
     * Origin the permission applies to, all origins if not specified.
     */
    @Nullable
    private final String origin;

    /**
     * BrowserContext to override permissions. When omitted, default browser context is used.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResetPermissionsRequest {
    /**
     * BrowserContext to reset permissions. When omitted, default browser context is used.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDownloadBehaviorRequest {
    /**
     * Whether to allow all or deny all download requests, or use default Chrome behavior if
     * available (otherwise deny). |allowAndName| allows download and names files according to
     * their download guids.
     */
    private final Behavior behavior;

    /**
     * BrowserContext to set download behavior. When omitted, default browser context is used.
     */
    @Nullable
    private final BrowserContextID browserContextId;

    /**
     * The default path to save downloaded files to. This is required if behavior is set to 'allow'
     * or 'allowAndName'.
     */
    @Nullable
    private final String downloadPath;

    /**
     * Whether to emit download events (defaults to false).
     */
    @Nullable
    private final Boolean eventsEnabled;

    public enum Behavior {
      @JsonProperty("deny")
      DENY,

      @JsonProperty("allow")
      ALLOW,

      @JsonProperty("allowAndName")
      ALLOW_AND_NAME,

      @JsonProperty("default")
      DEFAULT
    }
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CancelDownloadRequest {
    /**
     * Global unique identifier of the download.
     */
    private final String guid;

    /**
     * BrowserContext to perform the action in. When omitted, default browser context is used.
     */
    @Nullable
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetVersionResponse {
    /**
     * Protocol version.
     */
    private final String protocolVersion;

    /**
     * Product name.
     */
    private final String product;

    /**
     * Product revision.
     */
    private final String revision;

    /**
     * User-Agent.
     */
    private final String userAgent;

    /**
     * V8 version.
     */
    private final String jsVersion;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetBrowserCommandLineResponse {
    /**
     * Commandline parameters
     */
    private final List<String> arguments;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetHistogramsRequest {
    /**
     * Requested substring in name. Only histograms which have query as a
     * substring in their name are extracted. An empty or absent query returns
     * all histograms.
     */
    @Nullable
    private final String query;

    /**
     * If true, retrieve delta since last delta call.
     */
    @Nullable
    private final Boolean delta;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetHistogramsResponse {
    /**
     * Histograms.
     */
    private final List<Histogram> histograms;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetHistogramRequest {
    /**
     * Requested histogram name.
     */
    private final String name;

    /**
     * If true, retrieve delta since last delta call.
     */
    @Nullable
    private final Boolean delta;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetHistogramResponse {
    /**
     * Histogram.
     */
    private final Histogram histogram;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetWindowBoundsRequest {
    /**
     * Browser window id.
     */
    private final WindowID windowId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetWindowBoundsResponse {
    /**
     * Bounds information of the window. When window state is 'minimized', the restored window
     * position and size are returned.
     */
    private final Bounds bounds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetWindowForTargetRequest {
    /**
     * Devtools agent host id. If called as a part of the session, associated targetId is used.
     */
    @Nullable
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetWindowForTargetResponse {
    /**
     * Browser window id.
     */
    private final WindowID windowId;

    /**
     * Bounds information of the window. When window state is 'minimized', the restored window
     * position and size are returned.
     */
    private final Bounds bounds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetWindowBoundsRequest {
    /**
     * Browser window id.
     */
    private final WindowID windowId;

    /**
     * New window bounds. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined
     * with 'left', 'top', 'width' or 'height'. Leaves unspecified fields unchanged.
     */
    private final Bounds bounds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDockTileRequest {
    @Nullable
    private final String badgeLabel;

    /**
     * Png encoded image. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    private final String image;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ExecuteBrowserCommandRequest {
    private final BrowserCommandId commandId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AddPrivacySandboxEnrollmentOverrideRequest {
    private final String url;
  }

  /**
   * Fired when page is about to start a download.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DownloadWillBeginEvent {
    /**
     * Id of the frame that caused the download to begin.
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
}
