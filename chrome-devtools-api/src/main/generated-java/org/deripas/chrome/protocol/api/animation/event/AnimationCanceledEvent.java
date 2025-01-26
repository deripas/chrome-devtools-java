package org.deripas.chrome.protocol.api.animation.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Event for when an animation has been cancelled.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AnimationCanceledEvent {
  public static final EventId<AnimationCanceledEvent> ID = new EventId<>("Animation.animationCanceled", AnimationCanceledEvent.class);

  /**
   * Id of the animation that was cancelled.
   */
  private final String id;
}
