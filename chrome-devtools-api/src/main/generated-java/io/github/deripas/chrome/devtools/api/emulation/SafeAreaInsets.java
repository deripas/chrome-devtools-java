package io.github.deripas.chrome.devtools.api.emulation;

import java.lang.Integer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class SafeAreaInsets {
  /**
   * Overrides safe-area-inset-top.
   */
  @Nullable
  private final Integer top;

  /**
   * Overrides safe-area-max-inset-top.
   */
  @Nullable
  private final Integer topMax;

  /**
   * Overrides safe-area-inset-left.
   */
  @Nullable
  private final Integer left;

  /**
   * Overrides safe-area-max-inset-left.
   */
  @Nullable
  private final Integer leftMax;

  /**
   * Overrides safe-area-inset-bottom.
   */
  @Nullable
  private final Integer bottom;

  /**
   * Overrides safe-area-max-inset-bottom.
   */
  @Nullable
  private final Integer bottomMax;

  /**
   * Overrides safe-area-inset-right.
   */
  @Nullable
  private final Integer right;

  /**
   * Overrides safe-area-max-inset-right.
   */
  @Nullable
  private final Integer rightMax;
}
