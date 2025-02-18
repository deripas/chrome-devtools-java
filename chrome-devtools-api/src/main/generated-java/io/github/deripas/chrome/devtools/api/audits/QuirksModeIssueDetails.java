package io.github.deripas.chrome.devtools.api.audits;

import java.lang.Boolean;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.network.LoaderId;
import io.github.deripas.chrome.devtools.api.page.FrameId;

/**
 * Details for issues about documents in Quirks Mode
 * or Limited Quirks Mode that affects page layouting.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class QuirksModeIssueDetails {
  /**
   * If false, it means the document's mode is "quirks"
   * instead of "limited-quirks".
   */
  private final Boolean isLimitedQuirksMode;

  private final BackendNodeId documentNodeId;

  private final String url;

  private final FrameId frameId;

  private final LoaderId loaderId;
}
