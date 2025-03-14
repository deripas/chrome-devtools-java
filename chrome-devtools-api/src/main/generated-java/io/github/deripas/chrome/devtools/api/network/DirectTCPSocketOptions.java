package io.github.deripas.chrome.devtools.api.network;

import java.lang.Boolean;
import java.lang.Double;
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
public class DirectTCPSocketOptions {
  /**
   * TCP_NODELAY option
   */
  private final Boolean noDelay;

  /**
   * Expected to be unsigned integer.
   */
  @Nullable
  private final Double keepAliveDelay;

  /**
   * Expected to be unsigned integer.
   */
  @Nullable
  private final Double sendBufferSize;

  /**
   * Expected to be unsigned integer.
   */
  @Nullable
  private final Double receiveBufferSize;

  @Nullable
  private final DirectSocketDnsQueryType dnsQueryType;
}
