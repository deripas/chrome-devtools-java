package org.deripas.chrome.protocol.api.page;

import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Indicates whether a frame has been identified as an ad and why.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AdFrameStatus {
  private final AdFrameType adFrameType;

  @Nullable
  private final List<AdFrameExplanation> explanations;
}
