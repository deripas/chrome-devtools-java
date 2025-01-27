package org.deripas.chrome.protocol.api.log;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Violation configuration setting.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ViolationSetting {
  /**
   * Violation type.
   */
  private final Name name;

  /**
   * Time threshold to trigger upon.
   */
  private final Double threshold;

  public enum Name {
    @JsonProperty("longTask")
    LONG_TASK,

    @JsonProperty("longLayout")
    LONG_LAYOUT,

    @JsonProperty("blockedEvent")
    BLOCKED_EVENT,

    @JsonProperty("blockedParser")
    BLOCKED_PARSER,

    @JsonProperty("discouragedAPIUse")
    DISCOURAGED_A_P_I_USE,

    @JsonProperty("handler")
    HANDLER,

    @JsonProperty("recurringHandler")
    RECURRING_HANDLER
  }
}
