package org.deripas.chrome.protocol.api.profiler;

import java.lang.Double;
import java.lang.Integer;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Profile.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Profile {
  /**
   * The list of profile nodes. First item is the root node.
   */
  private final List<ProfileNode> nodes;

  /**
   * Profiling start timestamp in microseconds.
   */
  private final Double startTime;

  /**
   * Profiling end timestamp in microseconds.
   */
  private final Double endTime;

  /**
   * Ids of samples top nodes.
   */
  @Nullable
  private final List<Integer> samples;

  /**
   * Time intervals between adjacent samples in microseconds. The first delta is relative to the
   * profile startTime.
   */
  @Nullable
  private final List<Integer> timeDeltas;
}
