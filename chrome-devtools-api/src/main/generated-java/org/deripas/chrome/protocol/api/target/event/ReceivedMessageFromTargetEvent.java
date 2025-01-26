package org.deripas.chrome.protocol.api.target.event;

import java.lang.Deprecated;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.SessionID;
import org.deripas.chrome.protocol.api.target.TargetID;

/**
 * Notifies about a new protocol message received from the session (as reported in
 * `attachedToTarget` event).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ReceivedMessageFromTargetEvent {
  public static final EventId<ReceivedMessageFromTargetEvent> ID = new EventId<>("Target.receivedMessageFromTarget", ReceivedMessageFromTargetEvent.class);

  /**
   * Identifier of a session which sends a message.
   */
  private final SessionID sessionId;

  private final String message;

  /**
   * Deprecated.
   */
  @Nullable
  @Deprecated
  private final TargetID targetId;
}
