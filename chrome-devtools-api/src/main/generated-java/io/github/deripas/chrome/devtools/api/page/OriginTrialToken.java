package io.github.deripas.chrome.devtools.api.page;

import java.lang.Boolean;
import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class OriginTrialToken {
  private final String origin;

  private final Boolean matchSubDomains;

  private final String trialName;

  private final TimeSinceEpoch expiryTime;

  private final Boolean isThirdParty;

  private final OriginTrialUsageRestriction usageRestriction;
}
