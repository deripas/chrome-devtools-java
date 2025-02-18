package io.github.deripas.chrome.devtools.api.page;

import java.lang.Boolean;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Additional information about the frame document's security origin.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class SecurityOriginDetails {
  /**
   * Indicates whether the frame document's security origin is one
   * of the local hostnames (e.g. "localhost") or IP addresses (IPv4
   * 127.0.0.0/8 or IPv6 ::1).
   */
  private final Boolean isLocalhost;
}
