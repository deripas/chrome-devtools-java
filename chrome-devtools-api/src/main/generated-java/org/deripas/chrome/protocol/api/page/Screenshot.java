package org.deripas.chrome.protocol.api.page;

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
public class Screenshot {
  private final ImageResource image;

  private final String formFactor;

  @Nullable
  private final String label;
}
