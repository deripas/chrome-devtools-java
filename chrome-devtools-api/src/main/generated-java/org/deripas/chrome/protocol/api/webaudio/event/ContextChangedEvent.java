package org.deripas.chrome.protocol.api.webaudio.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.BaseAudioContext;

/**
 * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContextChangedEvent {
  public static final EventId<ContextChangedEvent> ID = new EventId<>("WebAudio.contextChanged", ContextChangedEvent.class);

  private final BaseAudioContext context;
}
