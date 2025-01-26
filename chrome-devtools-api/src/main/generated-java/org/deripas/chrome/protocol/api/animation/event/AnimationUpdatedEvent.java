package org.deripas.chrome.protocol.api.animation.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.animation.Animation;

/**
 * Event for animation that has been updated.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AnimationUpdatedEvent {
  public static final EventId<AnimationUpdatedEvent> ID = new EventId<>("Animation.animationUpdated", AnimationUpdatedEvent.class);

  /**
   * Animation that was updated.
   */
  private final Animation animation;
}
