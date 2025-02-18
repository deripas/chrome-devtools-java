package io.github.deripas.chrome.devtools.api.schema;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Description of the protocol domain.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Domain {
  /**
   * Domain name.
   */
  private final String name;

  /**
   * Domain version.
   */
  private final String version;
}
