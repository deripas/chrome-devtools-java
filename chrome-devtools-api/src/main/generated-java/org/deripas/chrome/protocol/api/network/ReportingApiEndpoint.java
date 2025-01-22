package org.deripas.chrome.protocol.api.network;

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
public class ReportingApiEndpoint {
  /**
   * The URL of the endpoint to which reports may be delivered.
   */
  private final String url;

  /**
   * Name of the endpoint group.
   */
  private final String groupName;
}
