package org.deripas.chrome.protocol.api.input.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.input.DragData;

/**
 * Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to
 * restore normal drag and drop behavior.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DragInterceptedEvent {
  public static final EventId<DragInterceptedEvent> ID = new EventId<>("Input.dragIntercepted", DragInterceptedEvent.class);

  private final DragData data;
}
