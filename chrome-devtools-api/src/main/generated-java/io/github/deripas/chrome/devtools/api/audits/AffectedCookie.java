package io.github.deripas.chrome.devtools.api.audits;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about a cookie that is affected by an inspector issue.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AffectedCookie {
  /**
   * The following three properties uniquely identify a cookie
   */
  private final String name;

  private final String path;

  private final String domain;
}
