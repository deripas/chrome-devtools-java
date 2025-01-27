package org.deripas.chrome.protocol.api.debugger;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Search match for resource.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SearchMatch {
  /**
   * Line number in resource content.
   */
  private final Double lineNumber;

  /**
   * Line with match content.
   */
  private final String lineContent;
}
