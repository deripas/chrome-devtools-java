package org.deripas.chrome.protocol.api.page;

import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * The image definition used in both icon and screenshot.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ImageResource {
  /**
   * The src field in the definition, but changing to url in favor of
   * consistency.
   */
  private final String url;

  @Nullable
  private final String sizes;

  @Nullable
  private final String type;
}
