package io.github.deripas.chrome.devtools.api.network;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class CorsErrorStatus {
  private final CorsError corsError;

  private final String failedParameter;
}
