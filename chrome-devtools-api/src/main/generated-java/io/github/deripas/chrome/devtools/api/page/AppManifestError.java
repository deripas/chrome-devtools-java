package io.github.deripas.chrome.devtools.api.page;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Error while paring app manifest.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AppManifestError {
  /**
   * Error message.
   */
  private final String message;

  /**
   * If critical, this is a non-recoverable parse error.
   */
  private final Integer critical;

  /**
   * Error line.
   */
  private final Integer line;

  /**
   * Error column.
   */
  private final Integer column;
}
