package org.deripas.chrome.protocol.api.preload;

import java.lang.Deprecated;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.dom.BackendNodeId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Corresponds to SpeculationRuleSet
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class RuleSet {
  private final RuleSetId id;

  /**
   * Identifies a document which the rule set is associated with.
   */
  private final LoaderId loaderId;

  /**
   * Source text of JSON representing the rule set. If it comes from
   * `<script>` tag, it is the textContent of the node. Note that it is
   * a JSON for valid case.
   *
   * See also:
   * - https://wicg.github.io/nav-speculation/speculation-rules.html
   * - https://github.com/WICG/nav-speculation/blob/main/triggers.md
   */
  private final String sourceText;

  /**
   * A speculation rule set is either added through an inline
   * `<script>` tag or through an external resource via the
   * 'Speculation-Rules' HTTP header. For the first case, we include
   * the BackendNodeId of the relevant `<script>` tag. For the second
   * case, we include the external URL where the rule set was loaded
   * from, and also RequestId if Network domain is enabled.
   *
   * See also:
   * - https://wicg.github.io/nav-speculation/speculation-rules.html#speculation-rules-script
   * - https://wicg.github.io/nav-speculation/speculation-rules.html#speculation-rules-header
   */
  @Nullable
  private final BackendNodeId backendNodeId;

  @Nullable
  private final String url;

  @Nullable
  private final RequestId requestId;

  /**
   * Error information
   * `errorMessage` is null iff `errorType` is null.
   */
  @Nullable
  private final RuleSetErrorType errorType;

  /**
   * TODO(https://crbug.com/1425354): Replace this property with structured error.
   */
  @Nullable
  @Deprecated
  private final String errorMessage;
}
