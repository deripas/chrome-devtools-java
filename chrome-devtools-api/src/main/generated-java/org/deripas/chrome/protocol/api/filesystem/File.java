package org.deripas.chrome.protocol.api.filesystem;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class File {
  private final String name;

  /**
   * Timestamp
   */
  private final TimeSinceEpoch lastModified;

  /**
   * Size in bytes
   */
  private final Double size;

  private final String type;
}
