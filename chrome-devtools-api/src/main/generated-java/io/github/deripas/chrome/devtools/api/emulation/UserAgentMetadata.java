package io.github.deripas.chrome.devtools.api.emulation;

import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Used to specify User Agent Client Hints to emulate. See https://wicg.github.io/ua-client-hints
 * Missing optional values will be filled in by the target with what it would normally use.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class UserAgentMetadata {
  /**
   * Brands appearing in Sec-CH-UA.
   */
  @Nullable
  private final List<UserAgentBrandVersion> brands;

  /**
   * Brands appearing in Sec-CH-UA-Full-Version-List.
   */
  @Nullable
  private final List<UserAgentBrandVersion> fullVersionList;

  @Nullable
  @Deprecated
  private final String fullVersion;

  private final String platform;

  private final String platformVersion;

  private final String architecture;

  private final String model;

  private final Boolean mobile;

  @Nullable
  private final String bitness;

  @Nullable
  private final Boolean wow64;
}
