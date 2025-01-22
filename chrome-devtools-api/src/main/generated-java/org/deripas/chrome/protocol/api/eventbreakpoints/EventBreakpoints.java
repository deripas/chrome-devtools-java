package org.deripas.chrome.protocol.api.eventbreakpoints;

import java.lang.String;
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
  void setInstrumentationBreakpoint(SetInstrumentationBreakpointRequest request);

  /**
   * Removes breakpoint on particular native event.
   */
  void removeInstrumentationBreakpoint(RemoveInstrumentationBreakpointRequest request);

  /**
   * Removes all breakpoints
   */
  void disable();

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
