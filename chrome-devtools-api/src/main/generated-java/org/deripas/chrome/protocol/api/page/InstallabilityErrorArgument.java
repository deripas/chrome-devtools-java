package org.deripas.chrome.protocol.api.page;

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
public class InstallabilityErrorArgument {
  /**
   * Argument name (e.g. name:'minimum-icon-size-in-pixels').
   */
  private final String name;

  /**
   * Argument value (e.g. value:'64').
   */
  private final String value;
}
