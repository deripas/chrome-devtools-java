package org.deripas.chrome.protocol.api.target.event;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.TargetID;

/**
 * Issued when a target has crashed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TargetCrashedEvent {
  public static final EventId<TargetCrashedEvent> ID = new EventId<>("Target.targetCrashed", TargetCrashedEvent.class);

  private final TargetID targetId;

  /**
   * Termination status type.
   */
  private final String status;

  /**
   * Termination error code.
   */
  private final Integer errorCode;
}
