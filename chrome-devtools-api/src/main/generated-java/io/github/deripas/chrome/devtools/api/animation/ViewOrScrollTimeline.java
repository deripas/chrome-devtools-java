package io.github.deripas.chrome.devtools.api.animation;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.dom.ScrollOrientation;

/**
 * Timeline instance
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ViewOrScrollTimeline {
  /**
   * Scroll container node
   */
  @Nullable
  private final BackendNodeId sourceNodeId;

  /**
   * Represents the starting scroll position of the timeline
   * as a length offset in pixels from scroll origin.
   */
  @Nullable
  private final Double startOffset;

  /**
   * Represents the ending scroll position of the timeline
   * as a length offset in pixels from scroll origin.
   */
  @Nullable
  private final Double endOffset;

  /**
   * The element whose principal box's visibility in the
   * scrollport defined the progress of the timeline.
   * Does not exist for animations with ScrollTimeline
   */
  @Nullable
  private final BackendNodeId subjectNodeId;

  /**
   * Orientation of the scroll
   */
  private final ScrollOrientation axis;
}
