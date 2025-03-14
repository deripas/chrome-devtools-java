package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS function conditional block representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSFunctionConditionNode {
  /**
   * Media query for this conditional block. Only one type of condition should be set.
   */
  @Nullable
  private final CSSMedia media;

  /**
   * Container query for this conditional block. Only one type of condition should be set.
   */
  @Nullable
  private final CSSContainerQuery containerQueries;

  /**
   * &commat;supports CSS at-rule condition. Only one type of condition should be set.
   */
  @Nullable
  private final CSSSupports supports;

  /**
   * Block body.
   */
  private final List<CSSFunctionNode> children;

  /**
   * The condition text.
   */
  private final String conditionText;
}
