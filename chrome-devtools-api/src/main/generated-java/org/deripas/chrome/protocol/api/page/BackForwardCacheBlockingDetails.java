package org.deripas.chrome.protocol.api.page;

import java.lang.Integer;
import java.lang.String;
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
public class BackForwardCacheBlockingDetails {
  /**
   * Url of the file where blockage happened. Optional because of tests.
   */
  @Nullable
  private final String url;

  /**
   * Function name where blockage happened. Optional because of anonymous functions and tests.
   */
  @Nullable
  private final String function;

  /**
   * Line number in the script (0-based).
   */
  private final Integer lineNumber;

  /**
   * Column number in the script (0-based).
   */
  private final Integer columnNumber;
}
