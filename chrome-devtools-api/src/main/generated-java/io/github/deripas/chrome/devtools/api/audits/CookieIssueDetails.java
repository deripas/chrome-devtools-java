package io.github.deripas.chrome.devtools.api.audits;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This information is currently necessary, as the front-end has a difficult
 * time finding a specific cookie. With this, we can convey specific error
 * information without the cookie.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CookieIssueDetails {
  /**
   * If AffectedCookie is not set then rawCookieLine contains the raw
   * Set-Cookie header string. This hints at a problem where the
   * cookie line is syntactically or semantically malformed in a way
   * that no valid cookie could be created.
   */
  @Nullable
  private final AffectedCookie cookie;

  @Nullable
  private final String rawCookieLine;

  private final List<CookieWarningReason> cookieWarningReasons;

  private final List<CookieExclusionReason> cookieExclusionReasons;

  /**
   * Optionally identifies the site-for-cookies and the cookie url, which
   * may be used by the front-end as additional context.
   */
  private final CookieOperation operation;

  @Nullable
  private final String siteForCookies;

  @Nullable
  private final String cookieUrl;

  @Nullable
  private final AffectedRequest request;

  /**
   * The recommended solution to the issue.
   */
  @Nullable
  private final CookieIssueInsight insight;
}
