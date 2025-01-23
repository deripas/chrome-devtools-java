package org.deripas.chrome.protocol.api.page;

import java.lang.Boolean;
import java.lang.String;
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
public class ScopeExtension {
  /**
   * Instead of using tuple, this field always returns the serialized string
   * for easy understanding and comparison.
   */
  private final String origin;

  private final Boolean hasOriginWildcard;
}
