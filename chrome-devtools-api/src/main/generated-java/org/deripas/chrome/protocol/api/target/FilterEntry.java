package org.deripas.chrome.protocol.api.target;

import java.lang.Boolean;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A filter used by target query/discovery/auto-attach operations.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class FilterEntry {
  /**
   * If set, causes exclusion of matching targets from the list.
   */
  @Nullable
  private final Boolean exclude;

  /**
   * If not present, matches any type.
   */
  @Nullable
  private final String type;
}
