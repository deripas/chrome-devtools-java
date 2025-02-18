package io.github.deripas.chrome.devtools.api.network;

import java.lang.Integer;
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
public class ServiceWorkerRouterInfo {
  /**
   * ID of the rule matched. If there is a matched rule, this field will
   * be set, otherwiser no value will be set.
   */
  @Nullable
  private final Integer ruleIdMatched;

  /**
   * The router source of the matched rule. If there is a matched rule, this
   * field will be set, otherwise no value will be set.
   */
  @Nullable
  private final ServiceWorkerRouterSource matchedSourceType;

  /**
   * The actual router source used.
   */
  @Nullable
  private final ServiceWorkerRouterSource actualSourceType;
}
