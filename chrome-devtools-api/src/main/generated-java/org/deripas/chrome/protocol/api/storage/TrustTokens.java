package org.deripas.chrome.protocol.api.storage;

import java.lang.Long;
import java.lang.String;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Pair of issuer origin and number of available (signed, but not used) Trust
 * Tokens from that issuer.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class TrustTokens {
  private final String issuerOrigin;

  private final Long count;
}
