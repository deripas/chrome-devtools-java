package org.deripas.chrome.protocol.api.runtime.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextDescription;

/**
 * Issued when new execution context is created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ExecutionContextCreatedEvent {
  public static final EventId<ExecutionContextCreatedEvent> ID = new EventId<>("Runtime.executionContextCreated", ExecutionContextCreatedEvent.class);

  /**
   * A newly created execution context.
   */
  private final ExecutionContextDescription context;
}
