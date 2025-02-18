package io.github.deripas.chrome.devtools.api.target;

import java.lang.Integer;
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
public class RemoteLocation {
  private final String host;

  private final Integer port;
}
