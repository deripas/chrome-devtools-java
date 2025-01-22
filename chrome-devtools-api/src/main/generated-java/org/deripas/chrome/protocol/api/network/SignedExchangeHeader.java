package org.deripas.chrome.protocol.api.network;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about a signed exchange header.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class SignedExchangeHeader {
  /**
   * Signed exchange request URL.
   */
  private final String requestUrl;

  /**
   * Signed exchange response code.
   */
  private final Integer responseCode;

  /**
   * Signed exchange response headers.
   */
  private final Headers responseHeaders;

  /**
   * Signed exchange response signature.
   */
  private final List<SignedExchangeSignature> signatures;

  /**
   * Signed exchange header integrity hash in the form of `sha256-<base64-hash-value>`.
   */
  private final String headerIntegrity;
}
