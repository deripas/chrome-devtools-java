package io.github.deripas.chrome.devtools.api.network;

import io.github.deripas.chrome.devtools.api.security.CertificateId;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Security details about a request.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SecurityDetails {
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
   * Certificate ID value.
   */
  private final CertificateId certificateId;

  /**
   * Certificate subject name.
   */
  private final String subjectName;

  /**
   * Subject Alternative Name (SAN) DNS names and IP addresses.
   */
  private final List<String> sanList;

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
   * List of signed certificate timestamps (SCTs).
   */
  private final List<SignedCertificateTimestamp> signedCertificateTimestampList;

  /**
   * Whether the request complied with Certificate Transparency policy
   */
  private final CertificateTransparencyCompliance certificateTransparencyCompliance;

  /**
   * The signature algorithm used by the server in the TLS server signature,
   * represented as a TLS SignatureScheme code point. Omitted if not
   * applicable or not known.
   */
  @Nullable
  private final Integer serverSignatureAlgorithm;

  /**
   * Whether the connection used Encrypted ClientHello
   */
  private final Boolean encryptedClientHello;
}
