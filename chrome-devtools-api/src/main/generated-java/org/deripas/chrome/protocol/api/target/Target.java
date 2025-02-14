package org.deripas.chrome.protocol.api.target;

import java.lang.Boolean;
import java.lang.Deprecated;
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
import org.deripas.chrome.protocol.api.browser.BrowserContextID;

/**
 * Supports additional targets discovery and allows to attach to them.
 */
@Generated
public interface Target {
  /**
   * Activates (focuses) the target.
   */
  CompletableFuture<Void> activateTarget(ActivateTargetRequest request);

  /**
   * Attaches to the target with given id.
   */
  CompletableFuture<AttachToTargetResponse> attachToTarget(AttachToTargetRequest request);

  /**
   * Attaches to the browser target, only uses flat sessionId mode.
   */
  CompletableFuture<AttachToBrowserTargetResponse> attachToBrowserTarget();

  /**
   * Closes the target. If the target is a page that gets closed too.
   */
  CompletableFuture<CloseTargetResponse> closeTarget(CloseTargetRequest request);

  /**
   * Inject object to the target's main frame that provides a communication
   * channel with browser target.
   *
   * Injected object will be available as `window[bindingName]`.
   *
   * The object has the following API:
   * - `binding.send(json)` - a method to send messages over the remote debugging protocol
   * - `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
   */
  CompletableFuture<Void> exposeDevToolsProtocol(ExposeDevToolsProtocolRequest request);

  /**
   * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
   * one.
   */
  CompletableFuture<CreateBrowserContextResponse> createBrowserContext(
      CreateBrowserContextRequest request);

  /**
   * Returns all browser contexts created with `Target.createBrowserContext` method.
   */
  CompletableFuture<GetBrowserContextsResponse> getBrowserContexts();

  /**
   * Creates a new page.
   */
  CompletableFuture<CreateTargetResponse> createTarget(CreateTargetRequest request);

  /**
   * Detaches session with given id.
   */
  CompletableFuture<Void> detachFromTarget(DetachFromTargetRequest request);

  /**
   * Deletes a BrowserContext. All the belonging pages will be closed without calling their
   * beforeunload hooks.
   */
  CompletableFuture<Void> disposeBrowserContext(DisposeBrowserContextRequest request);

  /**
   * Returns information about a target.
   */
  CompletableFuture<GetTargetInfoResponse> getTargetInfo(GetTargetInfoRequest request);

  /**
   * Retrieves a list of available targets.
   */
  CompletableFuture<GetTargetsResponse> getTargets(GetTargetsRequest request);

  /**
   * Sends protocol message over session with given id.
   * Consider using flat mode instead; see commands attachToTarget, setAutoAttach,
   * and crbug.com/991325.
   */
  @Deprecated
  CompletableFuture<Void> sendMessageToTarget(SendMessageToTargetRequest request);

  /**
   * Controls whether to automatically attach to new targets which are considered to be related to
   * this one. When turned on, attaches to all existing related targets as well. When turned off,
   * automatically detaches from all currently attached targets.
   * This also clears all targets added by `autoAttachRelated` from the list of targets to watch
   * for creation of related targets.
   */
  CompletableFuture<Void> setAutoAttach(SetAutoAttachRequest request);

  /**
   * Adds the specified target to the list of targets that will be monitored for any related target
   * creation (such as child frames, child workers and new versions of service worker) and reported
   * through `attachedToTarget`. The specified target is also auto-attached.
   * This cancels the effect of any previous `setAutoAttach` and is also cancelled by subsequent
   * `setAutoAttach`. Only available at the Browser target.
   */
  CompletableFuture<Void> autoAttachRelated(AutoAttachRelatedRequest request);

  /**
   * Controls whether to discover available targets and notify via
   * `targetCreated/targetInfoChanged/targetDestroyed` events.
   */
  CompletableFuture<Void> setDiscoverTargets(SetDiscoverTargetsRequest request);

  /**
   * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
   * `true`.
   */
  CompletableFuture<Void> setRemoteLocations(SetRemoteLocationsRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class ActivateTargetRequest {
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AttachToTargetRequest {
    private final TargetID targetId;

    /**
     * Enables "flat" access to the session via specifying sessionId attribute in the commands.
     * We plan to make this the default, deprecate non-flattened mode,
     * and eventually retire it. See crbug.com/991325.
     */
    @Nullable
    private final Boolean flatten;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AttachToTargetResponse {
    /**
     * Id assigned to the session.
     */
    private final SessionID sessionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AttachToBrowserTargetResponse {
    /**
     * Id assigned to the session.
     */
    private final SessionID sessionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CloseTargetRequest {
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CloseTargetResponse {
    /**
     * Always set to true. If an error occurs, the response indicates protocol error.
     */
    @Deprecated
    private final Boolean success;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ExposeDevToolsProtocolRequest {
    private final TargetID targetId;

    /**
     * Binding name, 'cdp' if not specified.
     */
    @Nullable
    private final String bindingName;

    /**
     * If true, inherits the current root session's permissions (default: false).
     */
    @Nullable
    private final Boolean inheritPermissions;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateBrowserContextRequest {
    /**
     * If specified, disposes this context when debugging session disconnects.
     */
    @Nullable
    @Experimental
    private final Boolean disposeOnDetach;

    /**
     * Proxy server, similar to the one passed to --proxy-server
     */
    @Nullable
    @Experimental
    private final String proxyServer;

    /**
     * Proxy bypass list, similar to the one passed to --proxy-bypass-list
     */
    @Nullable
    @Experimental
    private final String proxyBypassList;

    /**
     * An optional list of origins to grant unlimited cross-origin access to.
     * Parts of the URL other than those constituting origin are ignored.
     */
    @Nullable
    @Experimental
    private final List<String> originsWithUniversalNetworkAccess;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateBrowserContextResponse {
    /**
     * The id of the context created.
     */
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetBrowserContextsResponse {
    /**
     * An array of browser context ids.
     */
    private final List<BrowserContextID> browserContextIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateTargetRequest {
    /**
     * The initial URL the page will be navigated to. An empty string indicates about:blank.
     */
    private final String url;

    /**
     * Frame left origin in DIP (requires newWindow to be true or headless shell).
     */
    @Nullable
    @Experimental
    private final Integer left;

    /**
     * Frame top origin in DIP (requires newWindow to be true or headless shell).
     */
    @Nullable
    @Experimental
    private final Integer top;

    /**
     * Frame width in DIP (requires newWindow to be true or headless shell).
     */
    @Nullable
    private final Integer width;

    /**
     * Frame height in DIP (requires newWindow to be true or headless shell).
     */
    @Nullable
    private final Integer height;

    /**
     * Frame window state (requires newWindow to be true or headless shell).
     * Default is normal.
     */
    @Nullable
    private final WindowState windowState;

    /**
     * The browser context to create the page in.
     */
    @Nullable
    @Experimental
    private final BrowserContextID browserContextId;

    /**
     * Whether BeginFrames for this target will be controlled via DevTools (headless shell only,
     * not supported on MacOS yet, false by default).
     */
    @Nullable
    @Experimental
    private final Boolean enableBeginFrameControl;

    /**
     * Whether to create a new Window or Tab (false by default, not supported by headless shell).
     */
    @Nullable
    private final Boolean newWindow;

    /**
     * Whether to create the target in background or foreground (false by default, not supported
     * by headless shell).
     */
    @Nullable
    private final Boolean background;

    /**
     * Whether to create the target of type "tab".
     */
    @Nullable
    @Experimental
    private final Boolean forTab;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class CreateTargetResponse {
    /**
     * The id of the page opened.
     */
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DetachFromTargetRequest {
    /**
     * Session to detach.
     */
    @Nullable
    private final SessionID sessionId;

    /**
     * Deprecated.
     */
    @Nullable
    @Deprecated
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class DisposeBrowserContextRequest {
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetTargetInfoRequest {
    @Nullable
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetTargetInfoResponse {
    private final TargetInfo targetInfo;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetTargetsRequest {
    /**
     * Only targets matching filter will be reported. If filter is not specified
     * and target discovery is currently enabled, a filter used for target discovery
     * is used for consistency.
     */
    @Nullable
    @Experimental
    private final TargetFilter filter;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetTargetsResponse {
    /**
     * The list of targets.
     */
    private final List<TargetInfo> targetInfos;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SendMessageToTargetRequest {
    private final String message;

    /**
     * Identifier of the session.
     */
    @Nullable
    private final SessionID sessionId;

    /**
     * Deprecated.
     */
    @Nullable
    @Deprecated
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetAutoAttachRequest {
    /**
     * Whether to auto-attach to related targets.
     */
    private final Boolean autoAttach;

    /**
     * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger`
     * to run paused targets.
     */
    private final Boolean waitForDebuggerOnStart;

    /**
     * Enables "flat" access to the session via specifying sessionId attribute in the commands.
     * We plan to make this the default, deprecate non-flattened mode,
     * and eventually retire it. See crbug.com/991325.
     */
    @Nullable
    @Experimental
    private final Boolean flatten;

    /**
     * Only targets matching filter will be attached.
     */
    @Nullable
    @Experimental
    private final TargetFilter filter;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class AutoAttachRelatedRequest {
    private final TargetID targetId;

    /**
     * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger`
     * to run paused targets.
     */
    private final Boolean waitForDebuggerOnStart;

    /**
     * Only targets matching filter will be attached.
     */
    @Nullable
    @Experimental
    private final TargetFilter filter;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDiscoverTargetsRequest {
    /**
     * Whether to discover available targets.
     */
    private final Boolean discover;

    /**
     * Only targets matching filter will be attached. If `discover` is false,
     * `filter` must be omitted or empty.
     */
    @Nullable
    @Experimental
    private final TargetFilter filter;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetRemoteLocationsRequest {
    /**
     * List of remote locations.
     */
    private final List<RemoteLocation> locations;
  }
}
