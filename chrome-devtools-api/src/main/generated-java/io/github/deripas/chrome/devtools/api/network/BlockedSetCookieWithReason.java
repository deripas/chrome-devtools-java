package io.github.deripas.chrome.devtools.api.network;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A cookie which was not stored from a response with the corresponding reason.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class BlockedSetCookieWithReason {
  /**
   * The reason(s) this cookie was blocked.
   */
  private final List<SetCookieBlockedReason> blockedReasons;

  /**
   * The string representing this individual cookie as it would appear in the header.
   * This is not the entire "cookie" or "set-cookie" header which could have multiple cookies.
   */
  private final String cookieLine;

  /**
   * The cookie object which represents the cookie which was not stored. It is optional because
   * sometimes complete cookie information is not available, such as in the case of parsing
   * errors.
   */
  @Nullable
  private final Cookie cookie;
}
