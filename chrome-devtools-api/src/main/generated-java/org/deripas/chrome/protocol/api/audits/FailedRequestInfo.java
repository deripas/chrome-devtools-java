package org.deripas.chrome.protocol.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.RequestId;

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
