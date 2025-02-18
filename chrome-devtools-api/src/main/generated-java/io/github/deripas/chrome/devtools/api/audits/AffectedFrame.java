package io.github.deripas.chrome.devtools.api.audits;

import io.github.deripas.chrome.devtools.api.page.FrameId;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
