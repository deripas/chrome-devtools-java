package org.deripas.chrome.protocol.api.target.event;

import java.lang.Deprecated;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.target.SessionID;
import org.deripas.chrome.protocol.api.target.TargetID;

/**
 * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
 * issued multiple times per target if multiple sessions have been attached to it.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DetachedFromTargetEvent {
  public static final EventId<DetachedFromTargetEvent> ID = new EventId<>("Target.detachedFromTarget", DetachedFromTargetEvent.class);

  /**
   * Detached session identifier.
   */
  private final SessionID sessionId;

  /**
   * Deprecated.
   */
  @Nullable
  @Deprecated
  private final TargetID targetId;
}
