package org.deripas.chrome.protocol.api.network;

import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A cookie associated with the request which may or may not be sent with it.
 * Includes the cookies itself and reasons for blocking or exemption.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AssociatedCookie {
  /**
   * The cookie object representing the cookie which was not sent.
   */
  private final Cookie cookie;

  /**
   * The reason(s) the cookie was blocked. If empty means the cookie is included.
   */
  private final List<CookieBlockedReason> blockedReasons;

  /**
   * The reason the cookie should have been blocked by 3PCD but is exempted. A cookie could
   * only have at most one exemption reason.
   */
  @Nullable
  private final CookieExemptionReason exemptionReason;
}
