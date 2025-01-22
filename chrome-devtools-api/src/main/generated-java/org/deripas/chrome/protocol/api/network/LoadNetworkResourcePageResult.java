package org.deripas.chrome.protocol.api.network;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.io.StreamHandle;

/**
 * An object providing the result of a network resource load.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class LoadNetworkResourcePageResult {
  private final Boolean success;

  /**
   * Optional values used for error reporting.
   */
  @Nullable
  private final Long netError;

  @Nullable
  private final String netErrorName;

  @Nullable
  private final Long httpStatusCode;

  /**
   * If successful, one of the following two fields holds the result.
   */
  @Nullable
  private final StreamHandle stream;

  /**
   * Response headers.
   */
  @Nullable
  private final Headers headers;
}
