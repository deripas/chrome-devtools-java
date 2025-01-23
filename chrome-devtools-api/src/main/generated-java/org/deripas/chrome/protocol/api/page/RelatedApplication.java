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
public class RelatedApplication {
  @Nullable
  private final String id;

  private final String url;
}
