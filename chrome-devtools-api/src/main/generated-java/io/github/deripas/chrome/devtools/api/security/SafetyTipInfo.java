package io.github.deripas.chrome.devtools.api.security;

import java.lang.String;
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
public class SafetyTipInfo {
  /**
   * Describes whether the page triggers any safety tips or reputation warnings. Default is unknown.
   */
  private final SafetyTipStatus safetyTipStatus;

  /**
   * The URL the safety tip suggested ("Did you mean?"). Only filled in for lookalike matches.
   */
  @Nullable
  private final String safeUrl;
}
