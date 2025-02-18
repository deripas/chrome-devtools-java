package io.github.deripas.chrome.devtools.api.network;

import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about a signed exchange response.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class SignedExchangeInfo {
  /**
   * The outer response of signed HTTP exchange which was received from network.
   */
  private final Response outerResponse;

  /**
   * Information about the signed exchange header.
   */
  @Nullable
  private final SignedExchangeHeader header;

  /**
   * Security details for the signed exchange header.
   */
  @Nullable
  private final SecurityDetails securityDetails;

  /**
   * Errors occurred while handling the signed exchange.
   */
  @Nullable
  private final List<SignedExchangeError> errors;
}
