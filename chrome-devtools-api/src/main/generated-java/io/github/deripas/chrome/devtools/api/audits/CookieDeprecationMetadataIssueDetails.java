package io.github.deripas.chrome.devtools.api.audits;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue warns about third-party sites that are accessing cookies on the
 * current page, and have been permitted due to having a global metadata grant.
 * Note that in this context 'site' means eTLD+1. For example, if the URL
 * `https://example.test:80/web_page` was accessing cookies, the site reported
 * would be `example.test`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CookieDeprecationMetadataIssueDetails {
  private final List<String> allowedSites;

  private final Double optOutPercentage;

  private final Boolean isOptOutTopLevel;

  private final CookieOperation operation;
}
