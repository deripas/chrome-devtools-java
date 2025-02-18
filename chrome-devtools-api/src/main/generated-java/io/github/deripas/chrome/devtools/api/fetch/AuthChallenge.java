package io.github.deripas.chrome.devtools.api.fetch;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AuthChallenge {
  /**
   * Source of the authentication challenge.
   */
  @Nullable
  private final Source source;

  /**
   * Origin of the challenger.
   */
  private final String origin;

  /**
   * The authentication scheme used, such as basic or digest
   */
  private final String scheme;

  /**
   * The realm of the challenge. May be empty.
   */
  private final String realm;

  public enum Source {
    @JsonProperty("Server")
    SERVER,

    @JsonProperty("Proxy")
    PROXY
  }
}
