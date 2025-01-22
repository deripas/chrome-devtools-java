package org.deripas.chrome.protocol.api.audits;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Information about the frame affected by an inspector issue.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AffectedFrame {
  private final FrameId frameId;
}
