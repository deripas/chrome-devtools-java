package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that an existing AudioNode has been destroyed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioNodeWillBeDestroyedEvent {
  public static final EventId<AudioNodeWillBeDestroyedEvent> ID = new EventId<>("WebAudio.audioNodeWillBeDestroyed", AudioNodeWillBeDestroyedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId nodeId;
}
