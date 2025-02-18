package io.github.deripas.chrome.devtools.api.css;

import java.lang.Double;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * CSS Layer data.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CSSLayerData {
  /**
   * Layer name.
   */
  private final String name;

  /**
   * Direct sub-layers
   */
  @Nullable
  private final List<CSSLayerData> subLayers;

  /**
   * Layer order. The order determines the order of the layer in the cascade order.
   * A higher number has higher priority in the cascade order.
   */
  private final Double order;
}
