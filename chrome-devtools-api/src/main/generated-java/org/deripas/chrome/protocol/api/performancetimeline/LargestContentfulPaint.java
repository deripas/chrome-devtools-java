package org.deripas.chrome.protocol.api.performancetimeline;

import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LargestContentfulPaint {
  private final TimeSinceEpoch renderTime;

  private final TimeSinceEpoch loadTime;

  /**
   * The number of pixels being painted.
   */
  private final Double size;

  /**
   * The id attribute of the element, if available.
   */
  @Nullable
  private final String elementId;

  /**
   * The URL of the image (may be trimmed).
   */
  @Nullable
  private final String url;

  @Nullable
  private final BackendNodeId nodeId;
}
