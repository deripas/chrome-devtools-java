package io.github.deripas.chrome.devtools.api.css;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS function argument representation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSFunctionParameter {
  /**
   * The parameter name.
   */
  private final String name;

  /**
   * The parameter type.
   */
  private final String type;
}
