package org.deripas.chrome.protocol.api.runtime.event;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Issued when unhandled exception was revoked.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ExceptionRevokedEvent {
  public static final EventId<ExceptionRevokedEvent> ID = new EventId<>("Runtime.exceptionRevoked", ExceptionRevokedEvent.class);

  /**
   * Reason describing why exception was revoked.
   */
  private final String reason;

  /**
   * The id of revoked exception, as reported in `exceptionThrown`.
   */
  private final Integer exceptionId;
}
