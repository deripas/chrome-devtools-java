package io.github.deripas.chrome.devtools.api.network;

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
public class CrossOriginEmbedderPolicyStatus {
  private final CrossOriginEmbedderPolicyValue value;

  private final CrossOriginEmbedderPolicyValue reportOnlyValue;

  @Nullable
  private final String reportingEndpoint;

  @Nullable
  private final String reportOnlyReportingEndpoint;
}
