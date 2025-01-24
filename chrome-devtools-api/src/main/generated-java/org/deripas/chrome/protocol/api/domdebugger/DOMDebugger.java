package org.deripas.chrome.protocol.api.domdebugger;

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
import org.deripas.chrome.protocol.api.dom.NodeId;
import org.deripas.chrome.protocol.api.runtime.RemoteObjectId;

/**
 * DOM debugging allows setting breakpoints on particular DOM operations and events. JavaScript
 * execution will stop on these operations as if there was a regular breakpoint set.
 */
@Generated
public interface DOMDebugger {
  /**
   * Returns event listeners of the given object.
   */
  CompletableFuture<GetEventListenersResponse> getEventListeners(GetEventListenersRequest request);

  /**
   * Removes DOM breakpoint that was set using `setDOMBreakpoint`.
   */
  CompletableFuture<Void> removeDOMBreakpoint(RemoveDOMBreakpointRequest request);

  /**
   * Removes breakpoint on particular DOM event.
   */
  CompletableFuture<Void> removeEventListenerBreakpoint(
      RemoveEventListenerBreakpointRequest request);

  /**
   * Removes breakpoint on particular native event.
   */
  @Deprecated
  CompletableFuture<Void> removeInstrumentationBreakpoint(
      RemoveInstrumentationBreakpointRequest request);

  /**
   * Removes breakpoint from XMLHttpRequest.
   */
  CompletableFuture<Void> removeXHRBreakpoint(RemoveXHRBreakpointRequest request);

  /**
   * Sets breakpoint on particular CSP violations.
   */
  CompletableFuture<Void> setBreakOnCSPViolation(SetBreakOnCSPViolationRequest request);

  /**
   * Sets breakpoint on particular operation with DOM.
   */
  CompletableFuture<Void> setDOMBreakpoint(SetDOMBreakpointRequest request);

  /**
   * Sets breakpoint on particular DOM event.
   */
  CompletableFuture<Void> setEventListenerBreakpoint(SetEventListenerBreakpointRequest request);

  /**
   * Sets breakpoint on particular native event.
   */
  @Deprecated
  CompletableFuture<Void> setInstrumentationBreakpoint(SetInstrumentationBreakpointRequest request);

  /**
   * Sets breakpoint on XMLHttpRequest.
   */
  CompletableFuture<Void> setXHRBreakpoint(SetXHRBreakpointRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetEventListenersRequest {
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
  class GetEventListenersResponse {
    /**
     * Array of relevant listeners.
     */
    private final List<EventListener> listeners;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveDOMBreakpointRequest {
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
  class RemoveEventListenerBreakpointRequest {
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
  class RemoveInstrumentationBreakpointRequest {
    /**
     * Instrumentation name to stop on.
     */
    private final String eventName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RemoveXHRBreakpointRequest {
    /**
     * Resource URL substring.
     */
    private final String url;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetBreakOnCSPViolationRequest {
    /**
     * CSP Violations to stop upon.
     */
    private final List<CSPViolationType> violationTypes;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetDOMBreakpointRequest {
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
  class SetEventListenerBreakpointRequest {
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
  class SetInstrumentationBreakpointRequest {
    /**
     * Instrumentation name to stop on.
     */
    private final String eventName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetXHRBreakpointRequest {
    /**
     * Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
     */
    private final String url;
  }
}
