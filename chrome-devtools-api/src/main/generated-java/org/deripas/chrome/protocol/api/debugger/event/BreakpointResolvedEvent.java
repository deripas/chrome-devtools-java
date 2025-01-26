package org.deripas.chrome.protocol.api.debugger.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.debugger.BreakpointId;
import org.deripas.chrome.protocol.api.debugger.Location;

/**
 * Fired when breakpoint is resolved to an actual script and location.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BreakpointResolvedEvent {
  public static final EventId<BreakpointResolvedEvent> ID = new EventId<>("Debugger.breakpointResolved", BreakpointResolvedEvent.class);

  /**
   * Breakpoint unique identifier.
   */
  private final BreakpointId breakpointId;

  /**
   * Actual breakpoint location.
   */
  private final Location location;
}
