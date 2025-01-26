package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that a new AudioListener has been created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioListenerWillBeDestroyedEvent {
  public static final EventId<AudioListenerWillBeDestroyedEvent> ID = new EventId<>("WebAudio.audioListenerWillBeDestroyed", AudioListenerWillBeDestroyedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId listenerId;
}
