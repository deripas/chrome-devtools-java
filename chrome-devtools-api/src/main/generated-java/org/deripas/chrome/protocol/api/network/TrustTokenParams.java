package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Determines what type of Trust Token operation is executed and
 * depending on the type, some additional parameters. The values
 * are specified in third_party/blink/renderer/core/fetch/trust_token.idl.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class TrustTokenParams {
  private final TrustTokenOperationType operation;

  /**
   * Only set for "token-redemption" operation and determine whether
   * to request a fresh SRR or use a still valid cached SRR.
   */
  private final RefreshPolicy refreshPolicy;

  /**
   * Origins of issuers from whom to request tokens or redemption
   * records.
   */
  @Nullable
  private final List<String> issuers;

  public enum RefreshPolicy {
    @JsonProperty("UseCached")
    USE_CACHED,

    @JsonProperty("Refresh")
    REFRESH
  }
}
