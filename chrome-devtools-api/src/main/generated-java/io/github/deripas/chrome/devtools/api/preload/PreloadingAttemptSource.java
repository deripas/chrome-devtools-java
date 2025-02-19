package io.github.deripas.chrome.devtools.api.preload;

import io.github.deripas.chrome.devtools.api.dom.BackendNodeId;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Lists sources for a preloading attempt, specifically the ids of rule sets
 * that had a speculation rule that triggered the attempt, and the
 * BackendNodeIds of &lt;a href&gt; or &lt;area href&gt; elements that triggered the
 * attempt (in the case of attempts triggered by a document rule). It is
 * possible for multiple rule sets and links to trigger a single attempt.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PreloadingAttemptSource {
  private final PreloadingAttemptKey key;

  private final List<RuleSetId> ruleSetIds;

  private final List<BackendNodeId> nodeIds;
}
