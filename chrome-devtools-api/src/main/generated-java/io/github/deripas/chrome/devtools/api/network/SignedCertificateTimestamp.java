package io.github.deripas.chrome.devtools.api.network;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Details of a signed certificate timestamp (SCT).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SignedCertificateTimestamp {
  /**
   * Validation status.
   */
  private final String status;

  /**
   * Origin.
   */
  private final String origin;

  /**
   * Log name / description.
   */
  private final String logDescription;

  /**
   * Log ID.
   */
  private final String logId;

  /**
   * Issuance date. Unlike TimeSinceEpoch, this contains the number of
   * milliseconds since January 1, 1970, UTC, not the number of seconds.
   */
  private final Double timestamp;

  /**
   * Hash algorithm.
   */
  private final String hashAlgorithm;

  /**
   * Signature algorithm.
   */
  private final String signatureAlgorithm;

  /**
   * Signature data.
   */
  private final String signatureData;
}
