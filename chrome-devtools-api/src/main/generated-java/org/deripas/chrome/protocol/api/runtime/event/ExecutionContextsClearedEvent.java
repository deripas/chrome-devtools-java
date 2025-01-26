package org.deripas.chrome.protocol.api.runtime.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Issued when all executionContexts were cleared in browser
 */
@Generated
public class ExecutionContextsClearedEvent {
  public static final EventId<ExecutionContextsClearedEvent> ID = new EventId<>("Runtime.executionContextsCleared", ExecutionContextsClearedEvent.class);
}
