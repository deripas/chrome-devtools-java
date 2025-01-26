package org.deripas.chrome.protocol.api.runtime.event;

import java.lang.Deprecated;
import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextId;

/**
 * Issued when execution context is destroyed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ExecutionContextDestroyedEvent {
  public static final EventId<ExecutionContextDestroyedEvent> ID = new EventId<>("Runtime.executionContextDestroyed", ExecutionContextDestroyedEvent.class);

  /**
   * Id of the destroyed context
   */
  @Deprecated
  private final ExecutionContextId executionContextId;

  /**
   * Unique Id of the destroyed context
   */
  @Experimental
  private final String executionContextUniqueId;
}
