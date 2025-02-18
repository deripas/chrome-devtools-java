package io.github.deripas.chrome.devtools.api.page;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about the Frame hierarchy.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameTree {
  /**
   * Frame information for this tree item.
   */
  private final Frame frame;

  /**
   * Child frames.
   */
  @Nullable
  private final List<FrameTree> childFrames;
}
