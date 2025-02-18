package io.github.deripas.chrome.devtools.api.page;

import java.lang.String;
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
public class BackForwardCacheNotRestoredExplanation {
  /**
   * Type of the reason
   */
  private final BackForwardCacheNotRestoredReasonType type;

  /**
   * Not restored reason
   */
  private final BackForwardCacheNotRestoredReason reason;

  /**
   * Context associated with the reason. The meaning of this context is
   * dependent on the reason:
   * - EmbedderExtensionSentMessageToCachedFrame: the extension ID.
   */
  @Nullable
  private final String context;

  @Nullable
  private final List<BackForwardCacheBlockingDetails> details;
}
