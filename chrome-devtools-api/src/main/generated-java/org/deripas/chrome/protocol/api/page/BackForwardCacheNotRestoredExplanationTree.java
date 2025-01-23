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
public class BackForwardCacheNotRestoredExplanationTree {
  /**
   * URL of each frame
   */
  private final String url;

  /**
   * Not restored reasons of each frame
   */
  private final List<BackForwardCacheNotRestoredExplanation> explanations;

  /**
   * Array of children frame
   */
  private final List<BackForwardCacheNotRestoredExplanationTree> children;
}
