package io.github.deripas.chrome.devtools.api.page;

import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Parsed app manifest properties.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AppManifestParsedProperties {
  /**
   * Computed scope value
   */
  private final String scope;
}
