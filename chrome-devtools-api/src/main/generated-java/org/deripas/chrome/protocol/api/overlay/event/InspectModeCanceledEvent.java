package org.deripas.chrome.protocol.api.overlay.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when user cancels the inspect mode.
 */
@Generated
public class InspectModeCanceledEvent {
  public static final EventId<InspectModeCanceledEvent> ID = new EventId<>("Overlay.inspectModeCanceled", InspectModeCanceledEvent.class);
}
