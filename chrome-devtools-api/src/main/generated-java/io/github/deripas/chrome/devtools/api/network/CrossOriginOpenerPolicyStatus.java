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
public class CrossOriginOpenerPolicyStatus {
  private final CrossOriginOpenerPolicyValue value;

  private final CrossOriginOpenerPolicyValue reportOnlyValue;

  @Nullable
  private final String reportingEndpoint;

  @Nullable
  private final String reportOnlyReportingEndpoint;
}
