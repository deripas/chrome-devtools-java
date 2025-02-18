package io.github.deripas.chrome.devtools.api.animation;

import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;

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
  private final Double delay;

  /**
   * `AnimationEffect`'s end delay.
   */
  private final Double endDelay;

  /**
   * `AnimationEffect`'s iteration start.
   */
  private final Double iterationStart;

  /**
   * `AnimationEffect`'s iterations.
   */
  private final Double iterations;

  /**
   * `AnimationEffect`'s iteration duration.
   * Milliseconds for time based animations and
   * percentage [0 - 100] for scroll driven animations
   * (i.e. when viewOrScrollTimeline exists).
   */
  private final Double duration;

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
