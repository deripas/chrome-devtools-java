package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.AudioParam;

/**
 * Notifies that a new AudioParam has been created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioParamCreatedEvent {
  public static final EventId<AudioParamCreatedEvent> ID = new EventId<>("WebAudio.audioParamCreated", AudioParamCreatedEvent.class);

  private final AudioParam param;
}
