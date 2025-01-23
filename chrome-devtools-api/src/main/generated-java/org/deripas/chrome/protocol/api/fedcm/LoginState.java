package org.deripas.chrome.protocol.api.fedcm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Whether this is a sign-up or sign-in action for this account, i.e.
 * whether this account has ever been used to sign in to this RP before.
 */
@Generated
public enum LoginState {
  @JsonProperty("SignIn")
  SIGN_IN,

  @JsonProperty("SignUp")
  SIGN_UP
}
