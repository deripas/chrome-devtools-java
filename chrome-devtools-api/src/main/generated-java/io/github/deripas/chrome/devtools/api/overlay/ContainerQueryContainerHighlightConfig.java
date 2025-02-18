package io.github.deripas.chrome.devtools.api.overlay;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class ContainerQueryContainerHighlightConfig {
  /**
   * The style of the container border.
   */
  @Nullable
  private final LineStyle containerBorder;

  /**
   * The style of the descendants' borders.
   */
  @Nullable
  private final LineStyle descendantBorder;
}
