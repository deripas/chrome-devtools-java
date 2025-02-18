package io.github.deripas.chrome.devtools.api.audits;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.page.FrameId;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Depending on the concrete errorType, different properties are set.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class GenericIssueDetails {
  /**
   * Issues with the same errorType are aggregated in the frontend.
   */
  private final GenericIssueErrorType errorType;

  @Nullable
  private final FrameId frameId;

  @Nullable
  private final BackendNodeId violatingNodeId;

  @Nullable
  private final String violatingNodeAttribute;

  @Nullable
  private final AffectedRequest request;
}
