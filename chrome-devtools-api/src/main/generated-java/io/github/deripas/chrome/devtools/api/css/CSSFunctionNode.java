package io.github.deripas.chrome.devtools.api.css;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Section of the body of a CSS function rule.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSFunctionNode {
  /**
   * A conditional block. If set, style should not be set.
   */
  @Nullable
  private final CSSFunctionConditionNode condition;

  /**
   * Values set by this node. If set, condition should not be set.
   */
  @Nullable
  private final CSSStyle style;
}
