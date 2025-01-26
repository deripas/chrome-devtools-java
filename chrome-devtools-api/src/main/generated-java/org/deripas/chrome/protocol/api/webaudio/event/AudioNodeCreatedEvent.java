package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.AudioNode;

/**
 * Notifies that a new AudioNode has been created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioNodeCreatedEvent {
  public static final EventId<AudioNodeCreatedEvent> ID = new EventId<>("WebAudio.audioNodeCreated", AudioNodeCreatedEvent.class);

  private final AudioNode node;
}
