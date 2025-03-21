package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.deripas.chrome.devtools.api.runtime.StackTrace;
import java.lang.Double;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information about the request initiator.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Initiator {
  /**
   * Type of this initiator.
   */
  private final Type type;

  /**
   * Initiator JavaScript stack trace, set for Script only.
   * Requires the Debugger domain to be enabled.
   */
  @Nullable
  private final StackTrace stack;

  /**
   * Initiator URL, set for Parser type or for Script type (when script is importing module) or for SignedExchange type.
   */
  @Nullable
  private final String url;

  /**
   * Initiator line number, set for Parser type or for Script type (when script is importing
   * module) (0-based).
   */
  @Nullable
  private final Double lineNumber;

  /**
   * Initiator column number, set for Parser type or for Script type (when script is importing
   * module) (0-based).
   */
  @Nullable
  private final Double columnNumber;

  /**
   * Set if another request triggered this request (e.g. preflight).
   */
  @Nullable
  private final RequestId requestId;

  public enum Type {
    @JsonProperty("parser")
    PARSER,

    @JsonProperty("script")
    SCRIPT,

    @JsonProperty("preload")
    PRELOAD,

    @JsonProperty("SignedExchange")
    SIGNED_EXCHANGE,

    @JsonProperty("preflight")
    PREFLIGHT,

    @JsonProperty("other")
    OTHER
  }
}
