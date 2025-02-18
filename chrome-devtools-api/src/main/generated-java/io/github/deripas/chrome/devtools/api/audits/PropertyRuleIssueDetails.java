package io.github.deripas.chrome.devtools.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue warns about errors in property rules that lead to property
 * registrations being ignored.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PropertyRuleIssueDetails {
  /**
   * Source code position of the property rule.
   */
  private final SourceCodeLocation sourceCodeLocation;

  /**
   * Reason why the property rule was discarded.
   */
  private final PropertyRuleIssueReason propertyRuleIssueReason;

  /**
   * The value of the property rule property that failed to parse
   */
  @Nullable
  private final String propertyValue;
}
