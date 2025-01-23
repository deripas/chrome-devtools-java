package org.deripas.chrome.protocol.api.page;

import java.lang.String;
import java.util.List;
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
public class OriginTrial {
  private final String trialName;

  private final OriginTrialStatus status;

  private final List<OriginTrialTokenWithStatus> tokensWithStatus;
}
