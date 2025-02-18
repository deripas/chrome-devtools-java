package io.github.deripas.chrome.devtools.api.page;

import java.lang.String;
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
public class OriginTrialTokenWithStatus {
  private final String rawTokenText;

  /**
   * `parsedToken` is present only when the token is extractable and
   * parsable.
   */
  @Nullable
  private final OriginTrialToken parsedToken;

  private final OriginTrialTokenStatus status;
}
