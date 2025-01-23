package org.deripas.chrome.protocol.api.page;

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
public class PermissionsPolicyBlockLocator {
  private final FrameId frameId;

  private final PermissionsPolicyBlockReason blockReason;
}
