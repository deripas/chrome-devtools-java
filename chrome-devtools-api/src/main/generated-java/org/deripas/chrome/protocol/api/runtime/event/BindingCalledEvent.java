package org.deripas.chrome.protocol.api.runtime.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.runtime.ExecutionContextId;

/**
 * Notification is issued every time when binding is called.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BindingCalledEvent {
  public static final EventId<BindingCalledEvent> ID = new EventId<>("Runtime.bindingCalled", BindingCalledEvent.class);

  private final String name;

  private final String payload;

  /**
   * Identifier of the context where the call was made.
   */
  private final ExecutionContextId executionContextId;
}
