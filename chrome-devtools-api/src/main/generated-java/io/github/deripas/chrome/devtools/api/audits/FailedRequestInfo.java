package io.github.deripas.chrome.devtools.api.audits;

import io.github.deripas.chrome.devtools.api.network.RequestId;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class FailedRequestInfo {
  /**
   * The URL that failed to load.
   */
  private final String url;

  /**
   * The failure message for the failed request.
   */
  private final String failureMessage;

  @Nullable
  private final RequestId requestId;
}
