package io.github.deripas.chrome.devtools.api.eventbreakpoints;

import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * EventBreakpoints permits setting JavaScript breakpoints on operations and events
 * occurring in native code invoked from JavaScript. Once breakpoint is hit, it is
 * reported through Debugger domain, similarly to regular breakpoints being hit.
 */
@Experimental
@Generated
public interface EventBreakpoints {
  /**
   * Sets breakpoint on particular native event.
   */
  CompletableFuture<Void> setInstrumentationBreakpoint(SetInstrumentationBreakpointRequest request);

  /**
   * Removes breakpoint on particular native event.
   */
  CompletableFuture<Void> removeInstrumentationBreakpoint(
      RemoveInstrumentationBreakpointRequest request);

  /**
   * Removes all breakpoints
   */
  CompletableFuture<Void> disable();

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
  class RemoveInstrumentationBreakpointRequest {
    /**
     * Instrumentation name to stop on.
     */
    private final String eventName;
  }
}
