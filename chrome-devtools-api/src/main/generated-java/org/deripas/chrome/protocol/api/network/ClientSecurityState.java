package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
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
public class ClientSecurityState {
  private final Boolean initiatorIsSecureContext;

  private final IPAddressSpace initiatorIPAddressSpace;

  private final PrivateNetworkRequestPolicy privateNetworkRequestPolicy;
}
