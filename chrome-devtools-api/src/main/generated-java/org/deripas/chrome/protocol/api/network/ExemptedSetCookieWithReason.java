package org.deripas.chrome.protocol.api.network;

import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A cookie should have been blocked by 3PCD but is exempted and stored from a response with the
 * corresponding reason. A cookie could only have at most one exemption reason.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ExemptedSetCookieWithReason {
  /**
   * The reason the cookie was exempted.
   */
  private final CookieExemptionReason exemptionReason;

  /**
   * The string representing this individual cookie as it would appear in the header.
   */
  private final String cookieLine;

  /**
   * The cookie object representing the cookie.
   */
  private final Cookie cookie;
}
