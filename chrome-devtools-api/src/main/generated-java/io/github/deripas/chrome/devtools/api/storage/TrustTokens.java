package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Double;
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

  private final Double count;
}
