package io.github.deripas.chrome.devtools.api.accessibility;

import java.lang.Object;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A single computed AX property.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AXValue {
  /**
   * The type of this value.
   */
  private final AXValueType type;

  /**
   * The computed value of this property.
   */
  @Nullable
  private final Object value;

  /**
   * One or more related nodes, if applicable.
   */
  @Nullable
  private final List<AXRelatedNode> relatedNodes;

  /**
   * The sources which contributed to the computation of this property.
   */
  @Nullable
  private final List<AXValueSource> sources;
}
