package io.github.deripas.chrome.devtools.api.network;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about a signed exchange signature.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class SignedExchangeSignature {
  /**
   * Signed exchange signature label.
   */
  private final String label;

  /**
   * The hex string of signed exchange signature.
   */
  private final String signature;

  /**
   * Signed exchange signature integrity.
   */
  private final String integrity;

  /**
   * Signed exchange signature cert Url.
   */
  @Nullable
  private final String certUrl;

  /**
   * The hex string of signed exchange signature cert sha256.
   */
  @Nullable
  private final String certSha256;

  /**
   * Signed exchange signature validity Url.
   */
  private final String validityUrl;

  /**
   * Signed exchange signature date.
   */
  private final Integer date;

  /**
   * Signed exchange signature expires.
   */
  private final Integer expires;

  /**
   * The encoded certificates.
   */
  @Nullable
  private final List<String> certificates;
}
