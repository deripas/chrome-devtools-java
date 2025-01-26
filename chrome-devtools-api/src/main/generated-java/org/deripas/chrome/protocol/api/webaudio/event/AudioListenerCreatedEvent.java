package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.AudioListener;

/**
 * Notifies that the construction of an AudioListener has finished.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioListenerCreatedEvent {
  public static final EventId<AudioListenerCreatedEvent> ID = new EventId<>("WebAudio.audioListenerCreated", AudioListenerCreatedEvent.class);

  private final AudioListener listener;
}
