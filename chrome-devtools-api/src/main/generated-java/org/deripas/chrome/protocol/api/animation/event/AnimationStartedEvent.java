package org.deripas.chrome.protocol.api.animation.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.animation.Animation;

/**
 * Event for animation that has been started.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AnimationStartedEvent {
  public static final EventId<AnimationStartedEvent> ID = new EventId<>("Animation.animationStarted", AnimationStartedEvent.class);

  /**
   * Animation that was started.
   */
  private final Animation animation;
}
