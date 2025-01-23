package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * An options object that may be extended later to better support CORS,
 * CORB and streaming.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class LoadNetworkResourceOptions {
  private final Boolean disableCache;

  private final Boolean includeCredentials;
}
