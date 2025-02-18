package io.github.deripas.chrome.devtools.api.network;

import java.lang.Integer;
import java.lang.String;
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
public class SignedExchangeError {
  /**
   * Error message.
   */
  private final String message;

  /**
   * The index of the signature which caused the error.
   */
  @Nullable
  private final Integer signatureIndex;

  /**
   * The field which caused the error.
   */
  @Nullable
  private final SignedExchangeErrorField errorField;
}
