package org.deripas.chrome.protocol.api.systeminfo;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Represents process info.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ProcessInfo {
  /**
   * Specifies process type.
   */
  private final String type;

  /**
   * Specifies process id.
   */
  private final Integer id;

  /**
   * Specifies cumulative CPU usage in seconds across all threads of the
   * process since the process start.
   */
  private final Long cpuTime;
}
