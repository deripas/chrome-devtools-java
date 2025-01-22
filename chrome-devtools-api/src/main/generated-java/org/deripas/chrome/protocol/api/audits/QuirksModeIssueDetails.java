package org.deripas.chrome.protocol.api.audits;

import java.lang.Boolean;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.page.FrameId;

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
