package org.deripas.chrome.protocol.api.emulation;

import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Used to specify User Agent Client Hints to emulate. See https://wicg.github.io/ua-client-hints
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class UserAgentBrandVersion {
  private final String brand;

  private final String version;
}
