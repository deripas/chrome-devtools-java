package io.github.deripas.chrome.devtools.api.network;

import java.lang.Boolean;
import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * cookiePartitionKey object
 * The representation of the components of the key that are created by the cookiePartitionKey class contained in net/cookies/cookie_partition_key.h.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CookiePartitionKey {
  /**
   * The site of the top-level URL the browser was visiting at the start
   * of the request to the endpoint that set the cookie.
   */
  private final String topLevelSite;

  /**
   * Indicates if the cookie has any ancestors that are cross-site to the topLevelSite.
   */
  private final Boolean hasCrossSiteAncestor;
}
