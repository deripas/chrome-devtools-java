package io.github.deripas.chrome.devtools.api.css;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS keyframes rule representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSKeyframesRule {
  /**
   * Animation name.
   */
  private final Value animationName;

  /**
   * List of keyframes.
   */
  private final List<CSSKeyframeRule> keyframes;
}
