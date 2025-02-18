package io.github.deripas.chrome.devtools.api.security;

import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Details about the security state of the page certificate.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class CertificateSecurityState {
  /**
   * Protocol name (e.g. "TLS 1.2" or "QUIC").
   */
  private final String protocol;

  /**
   * Key Exchange used by the connection, or the empty string if not applicable.
   */
  private final String keyExchange;

  /**
   * (EC)DH group used by the connection, if applicable.
   */
  @Nullable
  private final String keyExchangeGroup;

  /**
   * Cipher name.
   */
  private final String cipher;

  /**
   * TLS MAC. Note that AEAD ciphers do not have separate MACs.
   */
  @Nullable
  private final String mac;

  /**
   * Page certificate.
   */
  private final List<String> certificate;

  /**
   * Certificate subject name.
   */
  private final String subjectName;

  /**
   * Name of the issuing CA.
   */
  private final String issuer;

  /**
   * Certificate valid from date.
   */
  private final TimeSinceEpoch validFrom;

  /**
   * Certificate valid to (expiration) date
   */
  private final TimeSinceEpoch validTo;

  /**
   * The highest priority network error code, if the certificate has an error.
   */
  @Nullable
  private final String certificateNetworkError;

  /**
   * True if the certificate uses a weak signature algorithm.
   */
  private final Boolean certificateHasWeakSignature;

  /**
   * True if the certificate has a SHA1 signature in the chain.
   */
  private final Boolean certificateHasSha1Signature;

  /**
   * True if modern SSL
   */
  private final Boolean modernSSL;

  /**
   * True if the connection is using an obsolete SSL protocol.
   */
  private final Boolean obsoleteSslProtocol;

  /**
   * True if the connection is using an obsolete SSL key exchange.
   */
  private final Boolean obsoleteSslKeyExchange;

  /**
   * True if the connection is using an obsolete SSL cipher.
   */
  private final Boolean obsoleteSslCipher;

  /**
   * True if the connection is using an obsolete SSL signature.
   */
  private final Boolean obsoleteSslSignature;
}
