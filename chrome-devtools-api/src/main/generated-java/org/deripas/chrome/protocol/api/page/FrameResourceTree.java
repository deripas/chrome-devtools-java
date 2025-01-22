package org.deripas.chrome.protocol.api.page;

import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about the Frame hierarchy along with their cached resources.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class FrameResourceTree {
  /**
   * Frame information for this tree item.
   */
  private final Frame frame;

  /**
   * Child frames.
   */
  @Nullable
  private final List<FrameResourceTree> childFrames;

  /**
   * Information about frame resources.
   */
  private final List<FrameResource> resources;
}
