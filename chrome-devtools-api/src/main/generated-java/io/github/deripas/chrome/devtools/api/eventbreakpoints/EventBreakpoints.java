package io.github.deripas.chrome.devtools.api.eventbreakpoints;

import io.github.deripas.chrome.devtools.api.Session;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * EventBreakpoints permits setting JavaScript breakpoints on operations and events
 * occurring in native code invoked from JavaScript. Once breakpoint is hit, it is
 * reported through Debugger domain, similarly to regular breakpoints being hit.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class EventBreakpoints {
  private final Session session;

  /**
   * Sets breakpoint on particular native event.
   */
  public CompletableFuture<Void> setInstrumentationBreakpoint(
      SetInstrumentationBreakpointRequest request) {
    return session.send("EventBreakpoints.setInstrumentationBreakpoint", request, Void.class);
  }

  /**
   * Removes breakpoint on particular native event.
   */
  public CompletableFuture<Void> removeInstrumentationBreakpoint(
      RemoveInstrumentationBreakpointRequest request) {
    return session.send("EventBreakpoints.removeInstrumentationBreakpoint", request, Void.class);
  }

  /**
   * Removes all breakpoints
   */
  public CompletableFuture<Void> disable() {
    return session.send("EventBreakpoints.disable", null, Void.class);
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
  public static class RemoveInstrumentationBreakpointRequest {
    /**
     * Instrumentation name to stop on.
     */
    private final String eventName;
  }
}
