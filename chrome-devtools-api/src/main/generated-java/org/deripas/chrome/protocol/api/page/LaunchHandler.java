package org.deripas.chrome.protocol.api.page;

import java.lang.String;
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
public class LaunchHandler {
  private final String clientMode;
}
