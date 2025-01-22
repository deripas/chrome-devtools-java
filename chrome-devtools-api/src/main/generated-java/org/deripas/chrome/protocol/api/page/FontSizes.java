package org.deripas.chrome.protocol.api.page;

import java.lang.Integer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Default font sizes.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class FontSizes {
  /**
   * Default standard font size.
   */
  @Nullable
  private final Integer standard;

  /**
   * Default fixed font size.
   */
  @Nullable
  private final Integer fixed;
}
