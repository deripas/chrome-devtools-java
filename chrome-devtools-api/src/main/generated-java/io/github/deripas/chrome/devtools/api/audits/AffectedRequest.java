package io.github.deripas.chrome.devtools.api.audits;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.RequestId;

/**
 * Information about a request that is affected by an inspector issue.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AffectedRequest {
  /**
   * The unique request id.
   */
  @Nullable
  private final RequestId requestId;

  private final String url;
}
