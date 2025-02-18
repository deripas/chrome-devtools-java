package io.github.deripas.chrome.devtools.api.accessibility;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class AXProperty {
  /**
   * The name of this property.
   */
  private final AXPropertyName name;

  /**
   * The value of this property.
   */
  private final AXValue value;
}
