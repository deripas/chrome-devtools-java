package org.deripas.chrome.protocol.api.page;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.ResourceType;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

/**
 * Information about the Resource on the page.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class FrameResource {
  /**
   * Resource URL.
   */
  private final String url;

  /**
   * Type of this resource.
   */
  private final ResourceType type;

  /**
   * Resource mimeType as determined by the browser.
   */
  private final String mimeType;

  /**
   * last-modified timestamp as reported by server.
   */
  @Nullable
  private final TimeSinceEpoch lastModified;

  /**
   * Resource content size.
   */
  @Nullable
  private final Double contentSize;

  /**
   * True if the resource failed to load.
   */
  @Nullable
  private final Boolean failed;

  /**
   * True if the resource was canceled during loading.
   */
  @Nullable
  private final Boolean canceled;
}
