package org.deripas.chrome.protocol.api.runtime.event;

import java.util.Map;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextId;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API
 * call).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class InspectRequestedEvent {
  public static final EventId<InspectRequestedEvent> ID = new EventId<>("Runtime.inspectRequested", InspectRequestedEvent.class);

  private final RemoteObject object;

  private final Map hints;

  /**
   * Identifier of the context where the call was made.
   */
  @Nullable
  @Experimental
  private final ExecutionContextId executionContextId;
}
