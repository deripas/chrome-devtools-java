package org.deripas.chrome.protocol.api.network.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.RequestId;
import org.deripas.chrome.protocol.api.network.TrustTokenOperationType;

/**
 * Fired exactly once for each Trust Token operation. Depending on
 * the type of the operation and whether the operation succeeded or
 * failed, the event is fired before the corresponding request was sent
 * or after the response was received.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TrustTokenOperationDoneEvent {
  public static final EventId<TrustTokenOperationDoneEvent> ID = new EventId<>("Network.trustTokenOperationDone", TrustTokenOperationDoneEvent.class);

  /**
   * Detailed success or error status of the operation.
   * 'AlreadyExists' also signifies a successful operation, as the result
   * of the operation already exists und thus, the operation was abort
   * preemptively (e.g. a cache hit).
   */
  private final Status status;

  private final TrustTokenOperationType type;

  private final RequestId requestId;

  /**
   * Top level origin. The context in which the operation was attempted.
   */
  @Nullable
  private final String topLevelOrigin;

  /**
   * Origin of the issuer in case of a "Issuance" or "Redemption" operation.
   */
  @Nullable
  private final String issuerOrigin;

  /**
   * The number of obtained Trust Tokens on a successful "Issuance" operation.
   */
  @Nullable
  private final Integer issuedTokenCount;

  public enum Status {
    @JsonProperty("Ok")
    OK,

    @JsonProperty("InvalidArgument")
    INVALID_ARGUMENT,

    @JsonProperty("MissingIssuerKeys")
    MISSING_ISSUER_KEYS,

    @JsonProperty("FailedPrecondition")
    FAILED_PRECONDITION,

    @JsonProperty("ResourceExhausted")
    RESOURCE_EXHAUSTED,

    @JsonProperty("AlreadyExists")
    ALREADY_EXISTS,

    @JsonProperty("ResourceLimited")
    RESOURCE_LIMITED,

    @JsonProperty("Unauthorized")
    UNAUTHORIZED,

    @JsonProperty("BadResponse")
    BAD_RESPONSE,

    @JsonProperty("InternalError")
    INTERNAL_ERROR,

    @JsonProperty("UnknownError")
    UNKNOWN_ERROR,

    @JsonProperty("FulfilledLocally")
    FULFILLED_LOCALLY,

    @JsonProperty("SiteIssuerLimit")
    SITE_ISSUER_LIMIT
  }
}
