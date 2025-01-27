package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Cookie object
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Cookie {
  /**
   * Cookie name.
   */
  private final String name;

  /**
   * Cookie value.
   */
  private final String value;

  /**
   * Cookie domain.
   */
  private final String domain;

  /**
   * Cookie path.
   */
  private final String path;

  /**
   * Cookie expiration date as the number of seconds since the UNIX epoch.
   */
  private final Double expires;

  /**
   * Cookie size.
   */
  private final Integer size;

  /**
   * True if cookie is http-only.
   */
  private final Boolean httpOnly;

  /**
   * True if cookie is secure.
   */
  private final Boolean secure;

  /**
   * True in case of session cookie.
   */
  private final Boolean session;

  /**
   * Cookie SameSite type.
   */
  @Nullable
  private final CookieSameSite sameSite;

  /**
   * Cookie Priority
   */
  @Experimental
  private final CookiePriority priority;

  /**
   * True if cookie is SameParty.
   */
  @Experimental
  @Deprecated
  private final Boolean sameParty;

  /**
   * Cookie source scheme type.
   */
  @Experimental
  private final CookieSourceScheme sourceScheme;

  /**
   * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port.
   * An unspecified port value allows protocol clients to emulate legacy cookie scope for the port.
   * This is a temporary ability and it will be removed in the future.
   */
  @Experimental
  private final Integer sourcePort;

  /**
   * Cookie partition key.
   */
  @Nullable
  @Experimental
  private final CookiePartitionKey partitionKey;

  /**
   * True if cookie partition key is opaque.
   */
  @Nullable
  @Experimental
  private final Boolean partitionKeyOpaque;
}
