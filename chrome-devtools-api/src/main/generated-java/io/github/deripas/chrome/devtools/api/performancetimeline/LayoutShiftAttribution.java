package io.github.deripas.chrome.devtools.api.performancetimeline;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import io.github.deripas.chrome.devtools.api.dom.Rect;

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
