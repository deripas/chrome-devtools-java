package io.github.deripas.chrome.devtools.api.network;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Request pattern for interception.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class RequestPattern {
  /**
   * Wildcards (`'*'` -&gt; zero or more, `'?'` -&gt; exactly one) are allowed. Escape character is
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
  private final InterceptionStage interceptionStage;
}
