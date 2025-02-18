package io.github.deripas.chrome.devtools.api.cachestorage;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Cached response
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CachedResponse {
  /**
   * Entry content, base64-encoded. (Encoded as a base64 string when passed over JSON)
   */
  private final String body;
}
