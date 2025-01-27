package org.deripas.chrome.protocol.api.network;

import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about the cached resource.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CachedResource {
  /**
   * Resource URL. This is the url of the original network request.
   */
  private final String url;

  /**
   * Type of this resource.
   */
  private final ResourceType type;

  /**
   * Cached response data.
   */
  @Nullable
  private final Response response;

  /**
   * Cached response body size.
   */
  private final Double bodySize;
}
