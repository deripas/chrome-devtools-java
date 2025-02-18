package io.github.deripas.chrome.devtools.api.network;

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
public class ContentSecurityPolicyStatus {
  private final String effectiveDirectives;

  private final Boolean isEnforced;

  private final ContentSecurityPolicySource source;
}
