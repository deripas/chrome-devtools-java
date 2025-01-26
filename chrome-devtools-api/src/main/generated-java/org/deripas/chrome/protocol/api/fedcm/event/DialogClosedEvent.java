package org.deripas.chrome.protocol.api.fedcm.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Triggered when a dialog is closed, either by user action, JS abort,
 * or a command below.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DialogClosedEvent {
  public static final EventId<DialogClosedEvent> ID = new EventId<>("FedCm.dialogClosed", DialogClosedEvent.class);

  private final String dialogId;
}
