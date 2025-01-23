package org.deripas.chrome.protocol.api.browser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.target.TargetID;

/**
 * The Browser domain defines methods and events for browser managing.
 */
@Generated
public interface Browser {
  /**
   * Set permission settings for given origin.
   */
  void setPermission(SetPermissionRequest request);

  /**
   * Grant specific permissions to the given origin and reject all others.
   */
  void grantPermissions(GrantPermissionsRequest request);

  /**
   * Reset all permission management for all origins.
   */
  void resetPermissions(ResetPermissionsRequest request);

  /**
   * Set the behavior when downloading a file.
   */
  void setDownloadBehavior(SetDownloadBehaviorRequest request);

  /**
   * Cancel a download if in progress
   */
  void cancelDownload(CancelDownloadRequest request);

  /**
   * Close browser gracefully.
   */
  void close();

  /**
   * Crashes browser on the main thread.
   */
  void crash();

  /**
   * Crashes GPU process.
   */
  void crashGpuProcess();

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
  void setWindowBounds(SetWindowBoundsRequest request);

  /**
   * Set dock tile details, platform-specific.
   */
  void setDockTile(SetDockTileRequest request);

  /**
   * Invoke custom browser commands used by telemetry.
   */
  void executeBrowserCommand(ExecuteBrowserCommandRequest request);

  /**
   * Allows a site to use privacy sandbox features that require enrollment
   * without the site actually being enrolled. Only supported on page targets.
   */
  void addPrivacySandboxEnrollmentOverride(AddPrivacySandboxEnrollmentOverrideRequest request);

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
}
