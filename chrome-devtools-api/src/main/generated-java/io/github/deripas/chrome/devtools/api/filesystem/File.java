package io.github.deripas.chrome.devtools.api.filesystem;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;

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
