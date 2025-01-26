package org.deripas.chrome.protocol.api.animation.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Event for each animation that has been created.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AnimationCreatedEvent {
  public static final EventId<AnimationCreatedEvent> ID = new EventId<>("Animation.animationCreated", AnimationCreatedEvent.class);

  /**
   * Id of the animation that was created.
   */
  private final String id;
}
