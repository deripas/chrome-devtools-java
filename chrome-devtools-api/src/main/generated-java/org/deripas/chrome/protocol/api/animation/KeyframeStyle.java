package org.deripas.chrome.protocol.api.animation;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Keyframe Style
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class KeyframeStyle {
  /**
   * Keyframe's time offset.
   */
  private final String offset;

  /**
   * `AnimationEffect`'s timing function.
   */
  private final String easing;
}
