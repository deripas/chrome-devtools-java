package io.github.deripas.chrome.devtools.api.pwa;

import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.target.TargetID;
import java.lang.Boolean;
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
import lombok.RequiredArgsConstructor;

/**
 * This domain allows interacting with the browser to control PWAs.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class PWA {
  private final Session session;

  /**
   * Returns the following OS state for the given manifest id.
   */
  public CompletableFuture<GetOsAppStateResponse> getOsAppState(GetOsAppStateRequest request) {
    return session.send("PWA.getOsAppState", request, GetOsAppStateResponse.class);
  }

  /**
   * Installs the given manifest identity, optionally using the given install_url
   * or IWA bundle location.
   *
   * TODO(crbug.com/337872319) Support IWA to meet the following specific
   * requirement.
   * IWA-specific install description: If the manifest_id is isolated-app://,
   * install_url_or_bundle_url is required, and can be either an http(s) URL or
   * file:// URL pointing to a signed web bundle (.swbn). The .swbn file's
   * signing key must correspond to manifest_id. If Chrome is not in IWA dev
   * mode, the installation will fail, regardless of the state of the allowlist.
   */
  public CompletableFuture<Void> install(InstallRequest request) {
    return session.send("PWA.install", request, Void.class);
  }

  /**
   * Uninstalls the given manifest_id and closes any opened app windows.
   */
  public CompletableFuture<Void> uninstall(UninstallRequest request) {
    return session.send("PWA.uninstall", request, Void.class);
  }

  /**
   * Launches the installed web app, or an url in the same web app instead of the
   * default start url if it is provided. Returns a page Target.TargetID which
   * can be used to attach to via Target.attachToTarget or similar APIs.
   */
  public CompletableFuture<LaunchResponse> launch(LaunchRequest request) {
    return session.send("PWA.launch", request, LaunchResponse.class);
  }

  /**
   * Opens one or more local files from an installed web app identified by its
   * manifestId. The web app needs to have file handlers registered to process
   * the files. The API returns one or more page Target.TargetIDs which can be
   * used to attach to via Target.attachToTarget or similar APIs.
   * If some files in the parameters cannot be handled by the web app, they will
   * be ignored. If none of the files can be handled, this API returns an error.
   * If no files are provided as the parameter, this API also returns an error.
   *
   * According to the definition of the file handlers in the manifest file, one
   * Target.TargetID may represent a page handling one or more files. The order
   * of the returned Target.TargetIDs is not guaranteed.
   *
   * TODO(crbug.com/339454034): Check the existences of the input files.
   */
  public CompletableFuture<LaunchFilesInAppResponse> launchFilesInApp(
      LaunchFilesInAppRequest request) {
    return session.send("PWA.launchFilesInApp", request, LaunchFilesInAppResponse.class);
  }

  /**
   * Opens the current page in its web app identified by the manifest id, needs
   * to be called on a page target. This function returns immediately without
   * waiting for the app to finish loading.
   */
  public CompletableFuture<Void> openCurrentPageInApp(OpenCurrentPageInAppRequest request) {
    return session.send("PWA.openCurrentPageInApp", request, Void.class);
  }

  /**
   * Changes user settings of the web app identified by its manifestId. If the
   * app was not installed, this command returns an error. Unset parameters will
   * be ignored; unrecognized values will cause an error.
   *
   * Unlike the ones defined in the manifest files of the web apps, these
   * settings are provided by the browser and controlled by the users, they
   * impact the way the browser handling the web apps.
   *
   * See the comment of each parameter.
   */
  public CompletableFuture<Void> changeAppUserSettings(ChangeAppUserSettingsRequest request) {
    return session.send("PWA.changeAppUserSettings", request, Void.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetOsAppStateRequest {
    /**
     * The id from the webapp's manifest file, commonly it's the url of the
     * site installing the webapp. See
     * https://web.dev/learn/pwa/web-app-manifest.
     */
    private final String manifestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetOsAppStateResponse {
    private final Integer badgeCount;

    private final List<FileHandler> fileHandlers;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class InstallRequest {
    private final String manifestId;

    /**
     * The location of the app or bundle overriding the one derived from the
     * manifestId.
     */
    @Nullable
    private final String installUrlOrBundleUrl;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UninstallRequest {
    private final String manifestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LaunchRequest {
    private final String manifestId;

    @Nullable
    private final String url;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LaunchResponse {
    /**
     * ID of the tab target created as a result.
     */
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LaunchFilesInAppRequest {
    private final String manifestId;

    private final List<String> files;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class LaunchFilesInAppResponse {
    /**
     * IDs of the tab targets created as the result.
     */
    private final List<TargetID> targetIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class OpenCurrentPageInAppRequest {
    private final String manifestId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ChangeAppUserSettingsRequest {
    private final String manifestId;

    /**
     * If user allows the links clicked on by the user in the app's scope, or
     * extended scope if the manifest has scope extensions and the flags
     * `DesktopPWAsLinkCapturingWithScopeExtensions` and
     * `WebAppEnableScopeExtensions` are enabled.
     *
     * Note, the API does not support resetting the linkCapturing to the
     * initial value, uninstalling and installing the web app again will reset
     * it.
     *
     * TODO(crbug.com/339453269): Setting this value on ChromeOS is not
     * supported yet.
     */
    @Nullable
    private final Boolean linkCapturing;

    @Nullable
    private final DisplayMode displayMode;
  }
}
