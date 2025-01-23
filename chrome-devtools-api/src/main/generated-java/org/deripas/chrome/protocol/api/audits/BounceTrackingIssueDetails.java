package org.deripas.chrome.protocol.api.audits;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue warns about sites in the redirect chain of a finished navigation
 * that may be flagged as trackers and have their state cleared if they don't
 * receive a user interaction. Note that in this context 'site' means eTLD+1.
 * For example, if the URL `https://example.test:80/bounce` was in the
 * redirect chain, the site reported would be `example.test`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BounceTrackingIssueDetails {
  private final List<String> trackingSites;
}
