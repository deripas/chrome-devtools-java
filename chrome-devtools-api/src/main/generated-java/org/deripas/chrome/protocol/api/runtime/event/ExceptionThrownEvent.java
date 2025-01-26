package org.deripas.chrome.protocol.api.runtime.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.runtime.ExceptionDetails;
import org.deripas.chrome.protocol.api.runtime.Timestamp;

/**
 * Issued when exception was thrown and unhandled.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ExceptionThrownEvent {
  public static final EventId<ExceptionThrownEvent> ID = new EventId<>("Runtime.exceptionThrown", ExceptionThrownEvent.class);

  /**
   * Timestamp of the exception.
   */
  private final Timestamp timestamp;

  private final ExceptionDetails exceptionDetails;
}
