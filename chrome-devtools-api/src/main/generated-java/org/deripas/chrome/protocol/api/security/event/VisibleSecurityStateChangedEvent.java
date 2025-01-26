package org.deripas.chrome.protocol.api.security.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.security.VisibleSecurityState;

/**
 * The security state of the page changed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class VisibleSecurityStateChangedEvent {
  public static final EventId<VisibleSecurityStateChangedEvent> ID = new EventId<>("Security.visibleSecurityStateChanged", VisibleSecurityStateChangedEvent.class);

  /**
   * Security state information about the page.
   */
  private final VisibleSecurityState visibleSecurityState;
}
