package io.github.deripas.chrome.devtools.api.domdebugger;

import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.dom.NodeId;
import io.github.deripas.chrome.devtools.api.runtime.RemoteObjectId;
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
import lombok.RequiredArgsConstructor;

/**
 * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
 * execution will stop on these operations as if there was a regular breakpoint set.
 */
@RequiredArgsConstructor
@Generated
public class DOMDebugger {
  private final Session session;

  /**
   * Returns event listeners of the given object.
   */
  public CompletableFuture<GetEventListenersResponse> getEventListeners(
      GetEventListenersRequest request) {
    return session.send("DOMDebugger.getEventListeners", request, GetEventListenersResponse.class);
  }

  /**
   * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
   */
  public CompletableFuture<Void> removeDOMBreakpoint(RemoveDOMBreakpointRequest request) {
    return session.send("DOMDebugger.removeDOMBreakpoint", request, Void.class);
  }

  /**
   * Removes breakpoint on particular DOM event.
   */
  public CompletableFuture<Void> removeEventListenerBreakpoint(
      RemoveEventListenerBreakpointRequest request) {
    return session.send("DOMDebugger.removeEventListenerBreakpoint", request, Void.class);
  }

  /**
   * Removes breakpoint on particular native event.
   */
  @Deprecated
  public CompletableFuture<Void> removeInstrumentationBreakpoint(
      RemoveInstrumentationBreakpointRequest request) {
    return session.send("DOMDebugger.removeInstrumentationBreakpoint", request, Void.class);
  }

  /**
   * Removes breakpoint from XMLHttpRequest.
   */
  public CompletableFuture<Void> removeXHRBreakpoint(RemoveXHRBreakpointRequest request) {
    return session.send("DOMDebugger.removeXHRBreakpoint", request, Void.class);
  }

  /**
   * Sets breakpoint on particular CSP violations.
   */
  public CompletableFuture<Void> setBreakOnCSPViolation(SetBreakOnCSPViolationRequest request) {
    return session.send("DOMDebugger.setBreakOnCSPViolation", request, Void.class);
  }

  /**
   * Sets breakpoint on particular operation with DOM.
   */
  public CompletableFuture<Void> setDOMBreakpoint(SetDOMBreakpointRequest request) {
    return session.send("DOMDebugger.setDOMBreakpoint", request, Void.class);
  }

  /**
   * Sets breakpoint on particular DOM event.
   */
  public CompletableFuture<Void> setEventListenerBreakpoint(
      SetEventListenerBreakpointRequest request) {
    return session.send("DOMDebugger.setEventListenerBreakpoint", request, Void.class);
  }

  /**
   * Sets breakpoint on particular native event.
   */
  @Deprecated
  public CompletableFuture<Void> setInstrumentationBreakpoint(
      SetInstrumentationBreakpointRequest request) {
    return session.send("DOMDebugger.setInstrumentationBreakpoint", request, Void.class);
  }

  /**
   * Sets breakpoint on XMLHttpRequest.
   */
  public CompletableFuture<Void> setXHRBreakpoint(SetXHRBreakpointRequest request) {
    return session.send("DOMDebugger.setXHRBreakpoint", request, Void.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetEventListenersRequest {
    /**
     * Identifier of the object to return listeners for.
     */
    private final RemoteObjectId objectId;

    /**
     * The maximum depth at which Node children should be retrieved, defaults to 1. Use -1 for the
     * entire subtree or provide an integer larger than 0.
     */
    @Nullable
    private final Integer depth;

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree
     * (default is false). Reports listeners for all contexts if pierce is enabled.
     */
    @Nullable
    private final Boolean pierce;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetEventListenersResponse {
    /**
     * Array of relevant listeners.
     */
    private final List<EventListener> listeners;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveDOMBreakpointRequest {
    /**
     * Identifier of the node to remove breakpoint from.
     */
    private final NodeId nodeId;

    /**
     * Type of the breakpoint to remove.
     */
    private final DOMBreakpointType type;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveEventListenerBreakpointRequest {
    /**
     * Event name.
     */
    private final String eventName;

    /**
     * EventTarget interface name.
     */
    @Nullable
    @Experimental
    private final String targetName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveInstrumentationBreakpointRequest {
    /**
     * Instrumentation name to stop on.
     */
    private final String eventName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class RemoveXHRBreakpointRequest {
    /**
     * Resource URL substring.
     */
    private final String url;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetBreakOnCSPViolationRequest {
    /**
     * CSP Violations to stop upon.
     */
    private final List<CSPViolationType> violationTypes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetDOMBreakpointRequest {
    /**
     * Identifier of the node to set breakpoint on.
     */
    private final NodeId nodeId;

    /**
     * Type of the operation to stop upon.
     */
    private final DOMBreakpointType type;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetEventListenerBreakpointRequest {
    /**
     * DOM Event name to stop on (any DOM event will do).
     */
    private final String eventName;

    /**
     * EventTarget interface name to stop on. If equal to `"*"` or not provided, will stop on any
     * EventTarget.
     */
    @Nullable
    @Experimental
    private final String targetName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetInstrumentationBreakpointRequest {
    /**
     * Instrumentation name to stop on.
     */
    private final String eventName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetXHRBreakpointRequest {
    /**
     * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
     */
    private final String url;
  }
}
