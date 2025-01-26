package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that an existing BaseAudioContext will be destroyed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContextWillBeDestroyedEvent {
  public static final EventId<ContextWillBeDestroyedEvent> ID = new EventId<>("WebAudio.contextWillBeDestroyed", ContextWillBeDestroyedEvent.class);

  private final GraphObjectId contextId;
}
