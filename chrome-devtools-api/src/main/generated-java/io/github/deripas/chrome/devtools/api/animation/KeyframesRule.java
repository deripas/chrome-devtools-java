package io.github.deripas.chrome.devtools.api.animation;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Keyframes Rule
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class KeyframesRule {
  /**
   * CSS keyframed animation's name.
   */
  @Nullable
  private final String name;

  /**
   * List of animation keyframes.
   */
  private final List<KeyframeStyle> keyframes;
}
