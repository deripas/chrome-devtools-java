package io.github.deripas.chrome.devtools.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Response to an AuthChallenge.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class AuthChallengeResponse {
  /**
   * The decision on what to do in response to the authorization challenge.  Default means
   * deferring to the default behavior of the net stack, which will likely either the Cancel
   * authentication or display a popup dialog box.
   */
  private final Response response;

  /**
   * The username to provide, possibly empty. Should only be set if response is
   * ProvideCredentials.
   */
  @Nullable
  private final String username;

  /**
   * The password to provide, possibly empty. Should only be set if response is
   * ProvideCredentials.
   */
  @Nullable
  private final String password;

  public enum Response {
    @JsonProperty("Default")
    DEFAULT,

    @JsonProperty("CancelAuth")
    CANCEL_AUTH,

    @JsonProperty("ProvideCredentials")
    PROVIDE_CREDENTIALS
  }
}
