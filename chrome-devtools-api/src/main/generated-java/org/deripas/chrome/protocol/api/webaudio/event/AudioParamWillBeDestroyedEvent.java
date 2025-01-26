package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that an existing AudioParam has been destroyed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioParamWillBeDestroyedEvent {
  public static final EventId<AudioParamWillBeDestroyedEvent> ID = new EventId<>("WebAudio.audioParamWillBeDestroyed", AudioParamWillBeDestroyedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId nodeId;

  private final GraphObjectId paramId;
}
