package io.github.deripas.chrome.devtools.api.network;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Cookie parameter object
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CookieParam {
  /**
   * Cookie name.
   */
  private final String name;

  /**
   * Cookie value.
   */
  private final String value;

  /**
   * The request-URI to associate with the setting of the cookie. This value can affect the
   * default domain, path, source port, and source scheme values of the created cookie.
   */
  @Nullable
  private final String url;

  /**
   * Cookie domain.
   */
  @Nullable
  private final String domain;

  /**
   * Cookie path.
   */
  @Nullable
  private final String path;

  /**
   * True if cookie is secure.
   */
  @Nullable
  private final Boolean secure;

  /**
   * True if cookie is http-only.
   */
  @Nullable
  private final Boolean httpOnly;

  /**
   * Cookie SameSite type.
   */
  @Nullable
  private final CookieSameSite sameSite;

  /**
   * Cookie expiration date, session cookie if not set
   */
  @Nullable
  private final TimeSinceEpoch expires;

  /**
   * Cookie Priority.
   */
  @Nullable
  @Experimental
  private final CookiePriority priority;

  /**
   * True if cookie is SameParty.
   */
  @Nullable
  @Experimental
  private final Boolean sameParty;

  /**
   * Cookie source scheme type.
   */
  @Nullable
  @Experimental
  private final CookieSourceScheme sourceScheme;

  /**
   * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port.
   * An unspecified port value allows protocol clients to emulate legacy cookie scope for the port.
   * This is a temporary ability and it will be removed in the future.
   */
  @Nullable
  @Experimental
  private final Integer sourcePort;

  /**
   * Cookie partition key. If not set, the cookie will be set as not partitioned.
   */
  @Nullable
  @Experimental
  private final CookiePartitionKey partitionKey;
}
