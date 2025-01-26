package org.deripas.chrome.protocol.api.target.event;

import java.lang.Boolean;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.SessionID;
import org.deripas.chrome.protocol.api.target.TargetInfo;

/**
 * Issued when attached to target because of auto-attach or `attachToTarget` command.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AttachedToTargetEvent {
  public static final EventId<AttachedToTargetEvent> ID = new EventId<>("Target.attachedToTarget", AttachedToTargetEvent.class);

  /**
   * Identifier assigned to the session used to send/receive messages.
   */
  private final SessionID sessionId;

  private final TargetInfo targetInfo;

  private final Boolean waitingForDebugger;
}
