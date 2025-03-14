package io.github.deripas.chrome.devtools.api.target;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.browser.BrowserContextID;
import java.lang.Boolean;
import java.lang.Deprecated;
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
 * Supports additional targets discovery and allows to attach to them.
 */
@RequiredArgsConstructor
@Generated
public class Target {
  private final Session session;

  /**
   * Activates (focuses) the target.
   */
  public CompletableFuture<Void> activateTarget(ActivateTargetRequest request) {
    return session.send("Target.activateTarget", request, Void.class);
  }

  /**
   * Attaches to the target with given id.
   */
  public CompletableFuture<AttachToTargetResponse> attachToTarget(AttachToTargetRequest request) {
    return session.send("Target.attachToTarget", request, AttachToTargetResponse.class);
  }

  /**
   * Attaches to the browser target, only uses flat sessionId mode.
   */
  public CompletableFuture<AttachToBrowserTargetResponse> attachToBrowserTarget() {
    return session.send("Target.attachToBrowserTarget", null, AttachToBrowserTargetResponse.class);
  }

  /**
   * Closes the target. If the target is a page that gets closed too.
   */
  public CompletableFuture<CloseTargetResponse> closeTarget(CloseTargetRequest request) {
    return session.send("Target.closeTarget", request, CloseTargetResponse.class);
  }

  /**
   * Inject object to the target's main frame that provides a communication
   * channel with browser target.
   *
   * Injected object will be available as `window[bindingName]`.
   *
   * The object has the following API:
   * - `binding.send(json)` - a method to send messages over the remote debugging protocol
   * - `binding.onmessage = json =&gt; handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
   */
  public CompletableFuture<Void> exposeDevToolsProtocol(ExposeDevToolsProtocolRequest request) {
    return session.send("Target.exposeDevToolsProtocol", request, Void.class);
  }

  /**
   * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
   * one.
   */
  public CompletableFuture<CreateBrowserContextResponse> createBrowserContext(
      CreateBrowserContextRequest request) {
    return session.send("Target.createBrowserContext", request, CreateBrowserContextResponse.class);
  }

  /**
   * Returns all browser contexts created with `Target.createBrowserContext` method.
   */
  public CompletableFuture<GetBrowserContextsResponse> getBrowserContexts() {
    return session.send("Target.getBrowserContexts", null, GetBrowserContextsResponse.class);
  }

  /**
   * Creates a new page.
   */
  public CompletableFuture<CreateTargetResponse> createTarget(CreateTargetRequest request) {
    return session.send("Target.createTarget", request, CreateTargetResponse.class);
  }

  /**
   * Detaches session with given id.
   */
  public CompletableFuture<Void> detachFromTarget(DetachFromTargetRequest request) {
    return session.send("Target.detachFromTarget", request, Void.class);
  }

  /**
   * Deletes a BrowserContext. All the belonging pages will be closed without calling their
   * beforeunload hooks.
   */
  public CompletableFuture<Void> disposeBrowserContext(DisposeBrowserContextRequest request) {
    return session.send("Target.disposeBrowserContext", request, Void.class);
  }

  /**
   * Returns information about a target.
   */
  public CompletableFuture<GetTargetInfoResponse> getTargetInfo(GetTargetInfoRequest request) {
    return session.send("Target.getTargetInfo", request, GetTargetInfoResponse.class);
  }

  /**
   * Retrieves a list of available targets.
   */
  public CompletableFuture<GetTargetsResponse> getTargets(GetTargetsRequest request) {
    return session.send("Target.getTargets", request, GetTargetsResponse.class);
  }

  /**
   * Sends protocol message over session with given id.
   * Consider using flat mode instead; see commands attachToTarget, setAutoAttach,
   * and crbug.com/991325.
   */
  @Deprecated
  public CompletableFuture<Void> sendMessageToTarget(SendMessageToTargetRequest request) {
    return session.send("Target.sendMessageToTarget", request, Void.class);
  }

  /**
   * Controls whether to automatically attach to new targets which are considered to be related to
   * this one. When turned on, attaches to all existing related targets as well. When turned off,
   * automatically detaches from all currently attached targets.
   * This also clears all targets added by `autoAttachRelated` from the list of targets to watch
   * for creation of related targets.
   */
  public CompletableFuture<Void> setAutoAttach(SetAutoAttachRequest request) {
    return session.send("Target.setAutoAttach", request, Void.class);
  }

  /**
   * Adds the specified target to the list of targets that will be monitored for any related target
   * creation (such as child frames, child workers and new versions of service worker) and reported
   * through `attachedToTarget`. The specified target is also auto-attached.
   * This cancels the effect of any previous `setAutoAttach` and is also cancelled by subsequent
   * `setAutoAttach`. Only available at the Browser target.
   */
  public CompletableFuture<Void> autoAttachRelated(AutoAttachRelatedRequest request) {
    return session.send("Target.autoAttachRelated", request, Void.class);
  }

  /**
   * Controls whether to discover available targets and notify via
   * `targetCreated/targetInfoChanged/targetDestroyed` events.
   */
  public CompletableFuture<Void> setDiscoverTargets(SetDiscoverTargetsRequest request) {
    return session.send("Target.setDiscoverTargets", request, Void.class);
  }

  /**
   * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
   * `true`.
   */
  public CompletableFuture<Void> setRemoteLocations(SetRemoteLocationsRequest request) {
    return session.send("Target.setRemoteLocations", request, Void.class);
  }

  public Disposable onAttachedToTarget(Consumer<AttachedToTargetEvent> listener) {
    return session.subscribe("Target.attachedToTarget", listener, AttachedToTargetEvent.class);
  }

  public Disposable onDetachedFromTarget(Consumer<DetachedFromTargetEvent> listener) {
    return session.subscribe("Target.detachedFromTarget", listener, DetachedFromTargetEvent.class);
  }

  public Disposable onReceivedMessageFromTarget(Consumer<ReceivedMessageFromTargetEvent> listener) {
    return session.subscribe("Target.receivedMessageFromTarget", listener, ReceivedMessageFromTargetEvent.class);
  }

  public Disposable onTargetCreated(Consumer<TargetCreatedEvent> listener) {
    return session.subscribe("Target.targetCreated", listener, TargetCreatedEvent.class);
  }

  public Disposable onTargetDestroyed(Consumer<TargetDestroyedEvent> listener) {
    return session.subscribe("Target.targetDestroyed", listener, TargetDestroyedEvent.class);
  }

  public Disposable onTargetCrashed(Consumer<TargetCrashedEvent> listener) {
    return session.subscribe("Target.targetCrashed", listener, TargetCrashedEvent.class);
  }

  public Disposable onTargetInfoChanged(Consumer<TargetInfoChangedEvent> listener) {
    return session.subscribe("Target.targetInfoChanged", listener, TargetInfoChangedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ActivateTargetRequest {
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AttachToTargetRequest {
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
  public static class AttachToTargetResponse {
    /**
     * Id assigned to the session.
     */
    private final SessionID sessionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class AttachToBrowserTargetResponse {
    /**
     * Id assigned to the session.
     */
    private final SessionID sessionId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CloseTargetRequest {
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CloseTargetResponse {
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
  public static class ExposeDevToolsProtocolRequest {
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
  public static class CreateBrowserContextRequest {
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
  public static class CreateBrowserContextResponse {
    /**
     * The id of the context created.
     */
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetBrowserContextsResponse {
    /**
     * An array of browser context ids.
     */
    private final List<BrowserContextID> browserContextIds;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CreateTargetRequest {
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
  public static class CreateTargetResponse {
    /**
     * The id of the page opened.
     */
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class DetachFromTargetRequest {
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
  public static class DisposeBrowserContextRequest {
    private final BrowserContextID browserContextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetTargetInfoRequest {
    @Nullable
    private final TargetID targetId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetTargetInfoResponse {
    private final TargetInfo targetInfo;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetTargetsRequest {
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
  public static class GetTargetsResponse {
    /**
     * The list of targets.
     */
    private final List<TargetInfo> targetInfos;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SendMessageToTargetRequest {
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
  public static class SetAutoAttachRequest {
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
  public static class AutoAttachRelatedRequest {
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
  public static class SetDiscoverTargetsRequest {
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
  public static class SetRemoteLocationsRequest {
    /**
     * List of remote locations.
     */
    private final List<RemoteLocation> locations;
  }

  /**
   * Issued when attached to target because of auto-attach or `attachToTarget` command.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class AttachedToTargetEvent {
    /**
     * Identifier assigned to the session used to send/receive messages.
     */
    private final SessionID sessionId;

    private final TargetInfo targetInfo;

    private final Boolean waitingForDebugger;
  }

  /**
   * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
   * issued multiple times per target if multiple sessions have been attached to it.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DetachedFromTargetEvent {
    /**
     * Detached session identifier.
     */
    private final SessionID sessionId;

    /**
     * Deprecated.
     */
    @Nullable
    @Deprecated
    private final TargetID targetId;
  }

  /**
   * Notifies about a new protocol message received from the session (as reported in
   * `attachedToTarget` event).
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReceivedMessageFromTargetEvent {
    /**
     * Identifier of a session which sends a message.
     */
    private final SessionID sessionId;

    private final String message;

    /**
     * Deprecated.
     */
    @Nullable
    @Deprecated
    private final TargetID targetId;
  }

  /**
   * Issued when a possible inspection target is created.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class TargetCreatedEvent {
    private final TargetInfo targetInfo;
  }

  /**
   * Issued when a target is destroyed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class TargetDestroyedEvent {
    private final TargetID targetId;
  }

  /**
   * Issued when a target has crashed.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class TargetCrashedEvent {
    private final TargetID targetId;

    /**
     * Termination status type.
     */
    private final String status;

    /**
     * Termination error code.
     */
    private final Integer errorCode;
  }

  /**
   * Issued when some information about a target has changed. This only happens between
   * `targetCreated` and `targetDestroyed`.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class TargetInfoChangedEvent {
    private final TargetInfo targetInfo;
  }
}
