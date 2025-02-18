package io.github.deripas.chrome.devtools.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about the suggested solution to a cookie issue.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CookieIssueInsight {
  private final InsightType type;

  /**
   * Link to table entry in third-party cookie migration readiness list.
   */
  @Nullable
  private final String tableEntryUrl;
}
