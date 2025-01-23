package org.deripas.chrome.protocol.api.network;

import java.util.List;
import javax.annotation.Nullable;
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
public class SecurityIsolationStatus {
  @Nullable
  private final CrossOriginOpenerPolicyStatus coop;

  @Nullable
  private final CrossOriginEmbedderPolicyStatus coep;

  @Nullable
  private final List<ContentSecurityPolicyStatus> csp;
}
