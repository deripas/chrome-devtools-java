package io.github.deripas.chrome.devtools.api.audits;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This issue warns when a referenced stylesheet couldn't be loaded.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StylesheetLoadingIssueDetails {
  /**
   * Source code position that referenced the failing stylesheet.
   */
  private final SourceCodeLocation sourceCodeLocation;

  /**
   * Reason why the stylesheet couldn't be loaded.
   */
  private final StyleSheetLoadingIssueReason styleSheetLoadingIssueReason;

  /**
   * Contains additional info when the failure was due to a request.
   */
  @Nullable
  private final FailedRequestInfo failedRequestInfo;
}
