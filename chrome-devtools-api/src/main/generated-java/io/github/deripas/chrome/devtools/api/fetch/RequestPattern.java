package io.github.deripas.chrome.devtools.api.fetch;

import io.github.deripas.chrome.devtools.api.network.ResourceType;
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
public class RequestPattern {
  /**
   * Wildcards (`'*'` -> zero or more, `'?'` -> exactly one) are allowed. Escape character is
   * backslash. Omitting is equivalent to `"*"`.
   */
  @Nullable
  private final String urlPattern;

  /**
   * If set, only requests for matching resource types will be intercepted.
   */
  @Nullable
  private final ResourceType resourceType;

  /**
   * Stage at which to begin intercepting requests. Default is Request.
   */
  @Nullable
  private final RequestStage requestStage;
}
