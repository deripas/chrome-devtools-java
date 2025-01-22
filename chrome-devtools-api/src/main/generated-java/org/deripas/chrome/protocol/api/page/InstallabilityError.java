package org.deripas.chrome.protocol.api.page;

import java.lang.String;
import java.util.List;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * The installability error
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class InstallabilityError {
  /**
   * The error id (e.g. 'manifest-missing-suitable-icon').
   */
  private final String errorId;

  /**
   * The list of error arguments (e.g. {name:'minimum-icon-size-in-pixels', value:'64'}).
   */
  private final List<InstallabilityErrorArgument> errorArguments;
}
