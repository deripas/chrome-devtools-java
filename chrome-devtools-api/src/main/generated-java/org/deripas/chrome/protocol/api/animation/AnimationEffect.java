package org.deripas.chrome.protocol.api.animation;

import java.lang.Long;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;

/**
 * AnimationEffect instance
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AnimationEffect {
  /**
   * `AnimationEffect`'s delay.
   */
  private final Long delay;

  /**
   * `AnimationEffect`'s end delay.
   */
  private final Long endDelay;

  /**
   * `AnimationEffect`'s iteration start.
   */
  private final Long iterationStart;

  /**
   * `AnimationEffect`'s iterations.
   */
  private final Long iterations;

  /**
   * `AnimationEffect`'s iteration duration.
   * Milliseconds for time based animations and
   * percentage [0 - 100] for scroll driven animations
   * (i.e. when viewOrScrollTimeline exists).
   */
  private final Long duration;

  /**
   * `AnimationEffect`'s playback direction.
   */
  private final String direction;

  /**
   * `AnimationEffect`'s fill mode.
   */
  private final String fill;

  /**
   * `AnimationEffect`'s target node.
   */
  @Nullable
  private final BackendNodeId backendNodeId;

  /**
   * `AnimationEffect`'s keyframes.
   */
  @Nullable
  private final KeyframesRule keyframesRule;

  /**
   * `AnimationEffect`'s timing function.
   */
  private final String easing;
}
