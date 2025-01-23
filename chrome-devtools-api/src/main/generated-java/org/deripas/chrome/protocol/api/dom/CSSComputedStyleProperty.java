package org.deripas.chrome.protocol.api.dom;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class CSSComputedStyleProperty {
  /**
   * Computed style property name.
   */
  private final String name;

  /**
   * Computed style property value.
   */
  private final String value;
}
