package io.github.deripas.chrome.devtools.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
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

/**
 * The Browser domain defines methods and events for browser managing.
 */
@Generated
public interface Browser {
  /**
   * Set permission settings for given origin.
   */
  CompletableFuture<Void> setPermission(SetPermissionRequest request);

  /**
   * Grant specific permissions to the given origin and reject all others.
   */
  CompletableFuture<Void> grantPermissions(GrantPermissionsRequest request);

  /**
   * Reset all permission management for all origins.
   */
  CompletableFuture<Void> resetPermissions(ResetPermissionsRequest request);

  /**
   * Set the behavior when downloading a file.
   */
  CompletableFuture<Void> setDownloadBehavior(SetDownloadBehaviorRequest request);

  /**
   * Cancel a download if in progress
   */
  CompletableFuture<Void> cancelDownload(CancelDownloadRequest request);

  /**
   * Close browser gracefully.
   */
  CompletableFuture<Void> close();

  /**
   * Crashes browser on the main thread.
   */
  CompletableFuture<Void> crash();

  /**
   * Crashes GPU process.
   */
  CompletableFuture<Void> crashGpuProcess();

  /**
   * Returns version information.
   */
  CompletableFuture<GetVersionResponse> getVersion();

  /**
   * Returns the command line switches for the browser process if, and only if
   * --enable-automation is on the commandline.
   */
  CompletableFuture<GetBrowserCommandLineResponse> getBrowserCommandLine();

  /**
   * Get Chrome histograms.
   */
  CompletableFuture<GetHistogramsResponse> getHistograms(GetHistogramsRequest request);

  /**
   * Get a Chrome histogram by name.
   */
  CompletableFuture<GetHistogramResponse> getHistogram(GetHistogramRequest request);

  /**
   * Get position and size of the browser window.
   */
  CompletableFuture<GetWindowBoundsResponse> getWindowBounds(GetWindowBoundsRequest request);

  /**
   * Get the browser window that contains the devtools target.
   */
  CompletableFuture<GetWindowForTargetResponse> getWindowForTarget(
      GetWindowForTargetRequest request);

  /**
   * Set position and/or size of the browser window.
   */
  CompletableFuture<Void> setWindowBounds(SetWindowBoundsRequest request);

  /**
   * Set dock tile details, platform-specific.
   */
  CompletableFuture<Void> setDockTile(SetDockTileRequest request);

  /**
   * Invoke custom browser commands used by telemetry.
   */
  CompletableFuture<Void> executeBrowserCommand(ExecuteBrowserCommandRequest request);

  /**
   * Allows a site to use privacy sandbox features that require enrollment
   * without the site actually being enrolled. Only supported on page targets.
   */
  CompletableFuture<Void> addPrivacySandboxEnrollmentOverride(
      AddPrivacySandboxEnrollmentOverrideRequest request);

  Disposable onDownloadWillBegin(Consumer<DownloadWillBeginEvent> listener);

  Disposable onDownloadProgress(Consumer<DownloadProgressEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class SetPermissionRequest {
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
  class GrantPermissionsRequest {
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
  class ResetPermissionsRequest {
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
  class SetDownloadBehaviorRequest {
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
  class CancelDownloadRequest {
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
  class GetVersionResponse {
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
  class GetBrowserCommandLineResponse {
    /**
     * Commandline parameters
     */
    private final List<String> arguments;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHistogramsRequest {
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
  class GetHistogramsResponse {
    /**
     * Histograms.
     */
    private final List<Histogram> histograms;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetHistogramRequest {
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
  class GetHistogramResponse {
    /**
     * Histogram.
     */
    private final Histogram histogram;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetWindowBoundsRequest {
    /**
     * Browser window id.
     */
    private final WindowID windowId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetWindowBoundsResponse {
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
  class GetWindowForTargetRequest {
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
  class GetWindowForTargetResponse {
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
  class SetWindowBoundsRequest {
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
  class SetDockTileRequest {
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
  class ExecuteBrowserCommandRequest {
    private final BrowserCommandId commandId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AddPrivacySandboxEnrollmentOverrideRequest {
    private final String url;
  }

  /**
   * Fired when page is about to start a download.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("downloadWillBegin")
  class DownloadWillBeginEvent {
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
  @JsonTypeName("downloadProgress")
  class DownloadProgressEvent {
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
