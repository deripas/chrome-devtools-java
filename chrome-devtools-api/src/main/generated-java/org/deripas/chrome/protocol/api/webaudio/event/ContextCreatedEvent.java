package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.BaseAudioContext;

/**
 * Notifies that a new BaseAudioContext has been created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContextCreatedEvent {
  public static final EventId<ContextCreatedEvent> ID = new EventId<>("WebAudio.contextCreated", ContextCreatedEvent.class);

  private final BaseAudioContext context;
}
