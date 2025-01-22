package org.deripas.chrome.protocol.api.profiler;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.CallFrame;

/**
 * Profile node. Holds callsite information, execution statistics and child nodes.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ProfileNode {
  /**
   * Unique id of the node.
   */
  private final Integer id;

  /**
   * Function location.
   */
  private final CallFrame callFrame;

  /**
   * Number of samples where this node was on top of the call stack.
   */
  @Nullable
  private final Integer hitCount;

  /**
   * Child node ids.
   */
  @Nullable
  private final List<Integer> children;

  /**
   * The reason of being not optimized. The function may be deoptimized or marked as don't
   * optimize.
   */
  @Nullable
  private final String deoptReason;

  /**
   * An array of source position ticks.
   */
  @Nullable
  private final List<PositionTickInfo> positionTicks;
}
