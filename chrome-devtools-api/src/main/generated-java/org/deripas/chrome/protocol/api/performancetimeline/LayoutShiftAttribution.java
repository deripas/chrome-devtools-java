package org.deripas.chrome.protocol.api.performancetimeline;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.dom.Rect;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayoutShiftAttribution {
  private final Rect previousRect;

  private final Rect currentRect;

  @Nullable
  private final BackendNodeId nodeId;
}
